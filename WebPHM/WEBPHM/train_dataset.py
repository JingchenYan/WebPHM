import pandas as pd
from datetime import datetime
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import MinMaxScaler, StandardScaler

file_path = 'D:/WebPHM/data/signal_machine_data.csv'
data = pd.read_csv(file_path)

data['出厂日期'] = pd.to_datetime(data['出厂日期'])
data['安装日期'] = pd.to_datetime(data['安装日期'])
data['故障日期'] = pd.to_datetime(data['故障日期'])

data.sort_values(by=['设备编号', '故障日期'], inplace=True)

data['下一次故障日期'] = data.groupby('设备编号')['故障日期'].shift(-1)
data['故障间隔天数'] = (data['下一次故障日期'] - data['故障日期']).dt.days
data['故障时年龄'] = (data['故障日期'] - data['安装日期']).dt.days

last_faults = data[data['下一次故障日期'].isna()]

filtered_data = data.dropna(subset=['故障间隔天数'])

csv_output_path = 'D:/WebPHM/data/processed_signal_machine_data.csv'
filtered_data.to_csv(csv_output_path, index=False)

excel_output_path = 'D:/WebPHM/data/processed_signal_machine_data.xlsx'
filtered_data.to_excel(excel_output_path, index=False, engine='openpyxl')

last_faults_csv_path = 'D:/WebPHM/data/last_faults_data.csv'
last_faults.to_csv(last_faults_csv_path, index=False)

last_faults_excel_path = 'D:/WebPHM/data/last_faults_data.xlsx'
last_faults.to_excel(last_faults_excel_path, index=False, engine='openpyxl')
