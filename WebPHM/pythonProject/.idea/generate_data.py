import pandas as pd
import numpy as np

np.random.seed(42)  # 设定随机种子

num_samples = 1000  # 设备数量

# 生成出厂日期和安装日期
manufacture_dates = pd.to_datetime(np.random.choice(pd.date_range(start='2010-01-01', end='2020-12-31'), num_samples))
installation_dates = manufacture_dates + pd.to_timedelta(np.random.randint(1, 181, num_samples), unit='d')

data_list = []

# 遍历每个设备，生成故障日期
for i in range(num_samples):
    device_id = i + 1
    manufacture_date = manufacture_dates[i]
    install_date = installation_dates[i]
    current_date = install_date

    # 控制循环次数以防止潜在的无限循环
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

        data_list.append({
            'Device ID': device_id,
            'Manufacture Date': manufacture_date,
            'Installation Date': install_date,
            'Fault Date': fault_date
        })
        current_date = fault_date

# 创建DataFrame
data = pd.DataFrame(data_list)

# 保存数据到Excel文件
excel_file_path = 'D:/WebPHM/data/generated_equipment_data.xlsx'
data.to_excel(excel_file_path, index=False, engine='openpyxl')
print("Data has been saved to Excel file at:", excel_file_path)

# 保存数据到CSV文件
csv_file_path = 'D:/WebPHM/data/generated_equipment_data.csv'
data.to_csv(csv_file_path, index=False)
print("Data has also been saved to CSV file at:", csv_file_path)
