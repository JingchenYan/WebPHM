import pandas as pd
from sklearn.preprocessing import MinMaxScaler
from tensorflow.keras.models import load_model

last_faults_path = 'D:/WebPHM/data/last_faults_data.csv'
last_faults_data = pd.read_csv(last_faults_path)

last_faults_data['出厂日期'] = pd.to_datetime(last_faults_data['出厂日期'])
last_faults_data['安装日期'] = pd.to_datetime(last_faults_data['安装日期'])
last_faults_data['故障日期'] = pd.to_datetime(last_faults_data['故障日期'])

last_faults_data['故障时年龄'] = (last_faults_data['故障日期'] - last_faults_data['安装日期']).dt.days

scaler = MinMaxScaler()
last_faults_data['故障时年龄'] = scaler.fit_transform(last_faults_data[['故障时年龄']])

model_path = 'D:/WebPHM/data/phm.keras'
model = load_model(model_path)

X = last_faults_data[['故障时年龄']].values.reshape(-1, 1, 1)
predicted_intervals = model.predict(X)

predicted_intervals = scaler.inverse_transform(predicted_intervals)

last_faults_data['预测的下一次故障间隔天数'] = predicted_intervals.flatten()
last_faults_data['预测的下一次故障日期'] = last_faults_data['故障日期'] + pd.to_timedelta(last_faults_data['预测的下一次故障间隔天数'], unit='d')

final_output_path_csv = 'D:/WebPHM/data/final_predictions.csv'
last_faults_data.to_csv(final_output_path_csv, index=False)

final_output_path_excel = 'D:/WebPHM/data/final_predictions.xlsx'
last_faults_data.to_excel(final_output_path_excel, index=False, engine='openpyxl')
