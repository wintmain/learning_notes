import numpy as np
from sklearn.metrics import mean_squared_error
from sklearn.datasets import make_friedman1
from sklearn.ensemble import GradientBoostingRegressor

X,y=make_friedman1(n_samples=1200,random_state=0,noise=1.0)
X_train,X_test=X[:200],X[200:]
y_train,y_test=y[:200],y[200:]
est=GradientBoostingRegressor().fit(X_train,y_train)
mean_squared_error(y_test,est.predict(X_test))

print(est.score(X_test,y_test))