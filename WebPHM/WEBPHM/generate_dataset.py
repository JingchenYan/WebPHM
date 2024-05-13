import os
import numpy as np
import pandas as pd
from datetime import datetime, timedelta

start_date = datetime(2000, 1, 1)
end_date = datetime(2020, 12, 31)
num_devices = 1000
scale = 180

np.random.seed(0)

factory_dates = pd.to_datetime(np.random.choice(pd.date_range(start_date, end_date), num_devices, replace=False))

installation_dates = []
for factory_date in factory_dates:
    proposed_date = factory_date + pd.to_timedelta(np.random.randint(0, 180), unit='d')
    if proposed_date > end_date:
        installation_dates.append(end_date)
    else:
        installation_dates.append(proposed_date)

installation_dates = pd.to_datetime(installation_dates)

def generate_faults(install_date):
    faults = []
    date = install_date
    while date < end_date:
        interval = np.random.exponential(scale)
        date += timedelta(days=int(interval))
        if date > end_date:
            break
        faults.append(date.date())
    return faults

faults_data = [generate_faults(install_date) for install_date in installation_dates]

rows = []
for idx, (factory_date, install_date, faults) in enumerate(zip(factory_dates, installation_dates, faults_data)):
    device_id = idx + 1
    if faults:
        for fault_date in faults:
            rows.append({"设备编号": device_id, "出厂日期": factory_date.date(), "安装日期": install_date.date(), "故障日期": fault_date})
    else:
        if (end_date - install_date).days < 180:
            while True:
                fault_interval = np.random.normal(loc=180, scale=30)
                fault_date1 = install_date + timedelta(days=int(fault_interval))
                if fault_date1 > end_date:
                    break
        else:
            if (end_date - install_date).days < 360:
                while True:
                    fault_interval = np.random.normal(loc=360, scale=30)
                    fault_date1 = install_date + timedelta(days=int(fault_interval))
                    if fault_date1 > end_date:
                        break
            else:
                if (end_date - install_date).days < 540:
                    while True:
                        fault_interval = np.random.normal(loc=540, scale=30)
                        fault_date1 = install_date + timedelta(days=int(fault_interval))
                        if fault_date1 > end_date:
                            print(type(fault_date1))
                            break
        fault_datetime = fault_date1.to_pydatetime()
        fault_date_only = fault_datetime.date()
        rows.append({"设备编号": device_id, "出厂日期": factory_date.date(), "安装日期": install_date.date(), "故障日期": fault_date_only})

df_long = pd.DataFrame(rows)

folder_path = 'D:/WebPHM/data'
if not os.path.exists(folder_path):
    os.makedirs(folder_path)

csv_path = os.path.join(folder_path, 'signal_machine_data.csv')
df_long.to_csv(csv_path, index=False)

excel_path = os.path.join(folder_path, 'signal_machine_data.xlsx')
df_long.to_excel(excel_path, index=False, engine='openpyxl')  # 使用openpyxl引擎

