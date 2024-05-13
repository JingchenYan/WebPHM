import pandas as pd
import numpy as np
from sqlalchemy import create_engine
import sqlalchemy

# Function to generate random names and fault types
def random_name():
    names = ["张三", "李四", "王五", "勾践", "嬴政", "曹操", "刘备", "孙权", "李世民", "赵匡胤"]
    return np.random.choice(names)

def random_fault():
    faults = ["传感器故障", "电源故障", "机械故障", "过热", "软件崩溃"]
    return np.random.choice(faults)

np.random.seed(42)  # Set random seed for reproducibility

# List of device names
device_names = ["Y_XD", "X_D", "X", "X_I", "X_II", "X_III", "X_4", "X_5", "S_II", "S_III", "S_4", "S_5", "D_1", "D_3", "D_5", "D_7", "D_9", "D_11", "D_13", "D_15", "D_17", "D_18"]

# Generate device information
num_devices = len(device_names)
manufacture_dates = pd.to_datetime(np.random.choice(pd.date_range(start='2010-01-01', end='2020-12-31'), num_devices))
installation_dates = manufacture_dates + pd.to_timedelta(np.random.randint(1, 181, num_devices), unit='d')

devices_df = pd.DataFrame({
    'XHJ_id': range(1, num_devices + 1),
    'XHJ_name': device_names,
    'XHJ_MDate': [md.date() for md in manufacture_dates],  # Correct date extraction
    'XHJ_IDate': [id.date() for id in installation_dates],  # Correct date extraction
    'XHJ_health': ['健康'] * num_devices
})

# Generate fault information
faults_data = []
for i in range(num_devices):
    install_date = installation_dates[i]
    current_date = install_date

    max_faults = 20  # 假设每台设备最多记录20次故障

    for _ in range(max_faults):
        service_years = (current_date - install_date).days / 365.25
        interval_reduction = service_years * 20  # 每过一年，故障间隔减少20天
        base_interval = 365 - interval_reduction
        min_interval = 30  # 故障间隔最小值为30天
        if base_interval < min_interval:
            base_interval = min_interval

        fault_interval = np.random.normal(base_interval, base_interval * 0.1)  # 添加10%的随机波动
        fault_date = current_date + pd.to_timedelta(max(int(fault_interval), 1), unit='d')

        if fault_date >= pd.Timestamp('2024-01-01'):
            break

        repair_date = fault_date + pd.to_timedelta(np.random.randint(1, 4), unit='d')  # Repair date within 1-3 days

        faults_data.append({
            'XHJ_FID': len(faults_data) + 1,
            'XHJ_FName': device_names[i],
            'XHJ_FDate': fault_date.date(),
            'XHJ_RDate': repair_date.date(),
            'XHJ_Pop': random_name(),
            'XHJ_Fault': random_fault()
        })
        current_date = fault_date

faults_df = pd.DataFrame(faults_data)

# Connect to database
engine = create_engine('mysql+pymysql://root:654547@localhost:3306/web')

# Insert data into database
devices_df.to_sql('xhj', con=engine, index=False, if_exists='replace', dtype={
    'XHJ_id': sqlalchemy.types.INTEGER(),
    'XHJ_name': sqlalchemy.types.VARCHAR(length=255),
    'XHJ_MDate': sqlalchemy.types.DATE(),
    'XHJ_IDate': sqlalchemy.types.DATE(),
    'XHJ_health': sqlalchemy.types.VARCHAR(length=255)
})
faults_df.to_sql('xhjf', con=engine, index=False, if_exists='replace', dtype={
    'XHJ_FID': sqlalchemy.types.INTEGER(),
    'XHJ_FName': sqlalchemy.types.VARCHAR(length=255),
    'XHJ_FDate': sqlalchemy.types.DATE(),
    'XHJ_RDate': sqlalchemy.types.DATE(),
    'XHJ_Pop': sqlalchemy.types.VARCHAR(length=255),
    'XHJ_Fault': sqlalchemy.types.VARCHAR(length=255)
})
