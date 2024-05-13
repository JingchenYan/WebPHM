import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from keras.models import Sequential
from keras.layers import LSTM, Dense, Dropout, Input, Bidirectional, Flatten
from tensorflow.keras.optimizers import Adam
from keras.regularizers import l2
from keras.callbacks import EarlyStopping

data_path = 'D:/WebPHM/data/processed_equipment_data.csv'
data = pd.read_csv(data_path)

# 设定窗口大小
window_size = 3

# 初始化存储处理后数据的列表
processed_data = []

# 按设备编号处理数据
for device_id in data['Device ID'].unique():
    temp_data = data[data['Device ID'] == device_id].copy()
    temp_data.sort_values(by='Fault Date', inplace=True)
    temp_data.reset_index(drop=True, inplace=True)

    # 创建滑动窗口
    for i in range(len(temp_data) - window_size):
        X_temp = temp_data.loc[i:i + window_size - 1, 'Fault Age'].values
        y_temp = temp_data.loc[i + window_size, 'Fault Interval Days']
        processed_data.append((X_temp, y_temp))

# 分割数据为训练集和测试集
X, y = zip(*processed_data)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# 调整输入格式以适配 LSTM
X_train = np.array(X_train).reshape(-1, window_size, 1)
X_test = np.array(X_test).reshape(-1, window_size, 1)
y_train = np.array(y_train)
y_test = np.array(y_test)

# 对目标变量应用对数变换
y_train_log = np.log(y_train + 1)
y_test_log = np.log(y_test + 1)

early_stopping = EarlyStopping(
    monitor='val_loss',   # 监控验证集损失
    patience=100,         # 如果100个epoch内没有改进就停止
    verbose=1,            # 打印早停的消息
    restore_best_weights=True  # 恢复最佳模型的权重
)

# 更新后的模型构建代码
model = Sequential([
    Input(shape=(window_size, 1)),
    Bidirectional(LSTM(64, return_sequences=True)),
    Dropout(0.3),
    Bidirectional(LSTM(128, return_sequences=True)),
    Dropout(0.3),
    Flatten(),
    Dense(128, activation='relu', kernel_regularizer=l2(0.01)),
    Dropout(0.3),
    Dense(64, activation='relu', kernel_regularizer=l2(0.01)),
    Dense(1, activation='linear')
])

optimizer = Adam(learning_rate=0.001)
model.compile(optimizer=optimizer, loss='mean_squared_logarithmic_error')

model.fit(
    X_train, y_train_log,
    epochs=2000,
    batch_size=512,
    validation_data=(X_test, y_test_log),
    verbose=1,
    callbacks=[early_stopping]  # 添加早停回调
)

model.summary()
model.save('D:/WebPHM/data/phm.keras')
