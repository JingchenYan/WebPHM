import pandas as pd
import numpy as np
from keras.models import load_model

# Load data
data_path = 'D:/WebPHM/data/generated_equipment_data.csv'
data = pd.read_csv(data_path)

# Sort by device ID and fault date
data.sort_values(by=['Device ID', 'Fault Date'], inplace=True)

# Calculate fault age (Fault Date - Installation Date)
data['Fault Date'] = pd.to_datetime(data['Fault Date'])
data['Installation Date'] = pd.to_datetime(data['Installation Date'])
data['Fault Age'] = (data['Fault Date'] - data['Installation Date']).dt.days

# Select the last fault record for each device
last_faults_data = data.drop_duplicates(subset=['Device ID'], keep='last').copy()

# Prepare model input data
X_predict = last_faults_data['Fault Age'].values.reshape(-1, 1, 1)  # Adjust according to the actual model structure

# Load model
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
last_faults_data.loc[:, 'Next Fault Date'] = pd.to_datetime(last_faults_data['Fault Date']) + pd.to_timedelta(predicted_intervals, unit='D')
last_faults_data.loc[:, 'Predicted Fault Interval Days'] = predicted_intervals

# Save results to Excel
excel_path = 'D:/WebPHM/data/predicted_next_fault_dates.xlsx'
last_faults_data.to_excel(excel_path, index=False)

# Save results to CSV
csv_path = 'D:/WebPHM/data/predicted_next_fault_dates.csv'
last_faults_data.to_csv(csv_path, index=False)
