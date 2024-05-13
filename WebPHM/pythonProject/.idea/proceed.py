import pandas as pd

# 加载数据
data_path = 'D:/WebPHM/data/generated_equipment_data.csv'
data = pd.read_csv(data_path)

# 按设备编号和故障日期排序
data.sort_values(by=['Device ID', 'Fault Date'], inplace=True)

# 计算故障时年龄（故障日期 - 安装日期）
data['Fault Date'] = pd.to_datetime(data['Fault Date'])  # 确保故障日期是日期类型
data['Installation Date'] = pd.to_datetime(data['Installation Date'])  # 确保安装日期是日期类型
data['Fault Age'] = (data['Fault Date'] - data['Installation Date']).dt.days

# 计算下一次故障日期和故障间隔天数
data['Next Fault Date'] = data.groupby('Device ID')['Fault Date'].shift(-1)
data['Fault Interval Days'] = (data['Next Fault Date'] - data['Fault Date']).dt.days

# 删除没有下一次故障日期的行，因为这些行没有用于训练的故障间隔天数
processed_data = data.dropna(subset=['Next Fault Date'])

# 保存数据到Excel文件
excel_file_path = 'D:/WebPHM/data/processed_equipment_data.xlsx'
data.to_excel(excel_file_path, index=False, engine='openpyxl')
print("Data has been saved to Excel file at:", excel_file_path)

# 保存处理后的数据到新的CSV文件
processed_file_path = 'D:/WebPHM/data/processed_equipment_data.csv'
processed_data.to_csv(processed_file_path, index=False)

print("Processed data has been saved to CSV file at:", processed_file_path)
