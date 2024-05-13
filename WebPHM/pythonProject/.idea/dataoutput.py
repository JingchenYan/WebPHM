from sqlalchemy import create_engine
import pandas as pd
import numpy as np
from keras.models import load_model
from sqlalchemy import create_engine, MetaData, Table, Column, Integer, String, Date
from sqlalchemy.sql import select, exists
import sys

try:
    # 创建数据库连接
    engine = create_engine('mysql+pymysql://root:654547@localhost:3306/web')

    # 执行 SQL 查询，联合两个表并选择必要的列
    query = """
    SELECT 
        j.XHJ_name AS 'Device ID',
        j.XHJ_MDate AS 'Manufacture Date',
        j.XHJ_IDate AS 'Installation Date',
        f.XHJ_FDate AS 'Fault Date'
    FROM 
        xhj j
    JOIN 
        xhjf f ON j.XHJ_name = f.XHJ_FName
    ORDER BY 
        j.XHJ_name, f.XHJ_FDate;
    """

    # 使用 Pandas 读取数据
    data = pd.read_sql(query, engine)

    # 转换日期格式
    data['Manufacture Date'] = pd.to_datetime(data['Manufacture Date'])
    data['Installation Date'] = pd.to_datetime(data['Installation Date'])
    data['Fault Date'] = pd.to_datetime(data['Fault Date'])

    data.to_excel('D:/WebPHM/data/full_equipment_data.xlsx', index=False, engine='openpyxl')
    # 保存到 CSV 文件
    data.to_csv('D:/WebPHM/data/full_equipment_data.csv', index=False)

    # Sort by device ID and fault date
    data.sort_values(by=['Device ID', 'Fault Date'], inplace=True)

    # Calculate fault age (Fault Date - Installation Date)
    data['Fault Date'] = pd.to_datetime(data['Fault Date'])
    data['Installation Date'] = pd.to_datetime(data['Installation Date'])
    data['Fault Age'] = (data['Fault Date'] - data['Installation Date']).dt.days

    # 选择每个设备的最后一次故障记录
    last_faults_data = data.drop_duplicates(subset=['Device ID'], keep='last')

    # 准备模型输入数据
    X_predict = last_faults_data['Fault Age'].values.reshape(-1, 1, 1)  # 根据实际模型结构调整

    # 加载模型
    model_path = 'D:/WebPHM/data/phm.keras'
    model = load_model(model_path)

    # Check and adjust the shape of the input data
    if X_predict.shape[1] != 3 or X_predict.shape[2] != 1:
        X_predict = np.repeat(X_predict, 3, axis=1)  # Repeat data three times
        X_predict = X_predict.reshape(-1, 3, 1)  # Ensure each sample is 3x1 in shape

    # Perform prediction with the adjusted X_predict
    predicted_intervals = model.predict(X_predict).flatten()
    predicted_intervals = np.exp(predicted_intervals) - 1  # Inverse log transformation

    # Calculate the next fault date
    last_faults_data = last_faults_data.copy()
    last_faults_data.loc[:, 'Next Fault Date'] = pd.to_datetime(last_faults_data['Fault Date']) + pd.to_timedelta(predicted_intervals, unit='D')
    last_faults_data.loc[:, 'Predicted Fault Interval Days'] = predicted_intervals

    # Save results to Excel
    excel_path = 'D:/WebPHM/data/next_fault_dates.xlsx'
    last_faults_data.to_excel(excel_path, index=False)

    # Save results to CSV
    csv_path = 'D:/WebPHM/data/next_fault_dates.csv'
    last_faults_data.to_csv(csv_path, index=False)

    # 使用 SQLAlchemy 的 MetaData 对象
    metadata = MetaData()

    # 定义新表
    xhjp_table = Table('xhjp', metadata,
                       Column('XHJ_PID', Integer, primary_key=True, autoincrement=True),
                       Column('XHJ_PName', String(255)),
                       Column('XHJ_PDate', Date))

    # 创建表（如果不存在）
    metadata = MetaData(engine)
    xhjp_table = Table('xhjp', metadata,
                       Column('XHJ_PID', Integer, primary_key=True, autoincrement=True),
                       Column('XHJ_PName', String(255), unique=True),
                       Column('XHJ_PDate', Date))
    metadata.create_all()

    with engine.connect() as conn:
        for idx, row in last_faults_data.iterrows():
            # Check if the data already exists
            if not conn.execute(select([exists().where(xhjp_table.c.XHJ_PName == row['Device ID'])])).scalar():
                insert_stmt = xhjp_table.insert().values(
                    XHJ_PName=row['Device ID'],
                    XHJ_PDate=row['Next Fault Date']
                )
                conn.execute(insert_stmt)

except Exception as e:
    print(f"An error occurred: {e}", file=sys.stderr)
    sys.exit(1)