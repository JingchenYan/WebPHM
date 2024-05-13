from keras.models import Sequential
from keras.layers import LSTM, Dense, Dropout, Input
from keras.optimizers import Adam
from sklearn.model_selection import train_test_split
import pandas as pd
import numpy as np

import tensorflow as tf

data_path = 'D:/WebPHM/data/processed_signal_machine_data.csv'
data = pd.read_csv(data_path)

# 设定窗口大小
window_size = 3

# 初始化存储处理后数据的列表
processed_data = []

# 按设备编号处理数据
for device_id in data['设备编号'].unique():
    temp_data = data[data['设备编号'] == device_id].copy()
    temp_data.sort_values(by='故障日期', inplace=True)
    temp_data.reset_index(drop=True, inplace=True)

    # 创建滑动窗口
    for i in range(len(temp_data) - window_size):
        X_temp = temp_data.loc[i:i + window_size - 1, '故障时年龄'].values
        y_temp = temp_data.loc[i + window_size, '故障间隔天数']
        processed_data.append((X_temp, y_temp))

# 分割数据为训练集和测试集
X, y = zip(*processed_data)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# 调整输入格式以适配 LSTM
X_train = np.array(X_train).reshape(-1, window_size, 1)
X_test = np.array(X_test).reshape(-1, window_size, 1)
y_train = np.array(y_train)
y_test = np.array(y_test)

# 建立模型
model = Sequential()
model.add(Input(shape=(window_size, 1)))  # 使用 Input 层
model.add(LSTM(50, return_sequences=True))
model.add(Dropout(0.2))
model.add(LSTM(30))
model.add(Dropout(0.2))
model.add(Dense(20, activation='relu'))
model.add(Dense(1))

# 编译模型
optimizer = Adam(learning_rate=0.001)
model.compile(optimizer='adam', loss='mean_squared_error')

# 自定义训练循环，每10次迭代显示一次结果
for epoch in range(1, 101):  # 100个epoch
    model.fit(X_train, y_train, epochs=1, batch_size=32, validation_data=(X_test, y_test), verbose=0)
    if epoch % 10 == 0:
        loss, val_loss = model.evaluate(X_train, y_train, verbose=0), model.evaluate(X_test, y_test, verbose=0)
        print(f"Epoch: {epoch}, Loss: {loss}, Validation Loss: {val_loss}")

model.save('D:/WebPHM/data/phm.keras')
