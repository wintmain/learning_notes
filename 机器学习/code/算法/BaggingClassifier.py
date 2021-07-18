from sklearn.svm import SVC
from sklearn.ensemble import BaggingClassifier
from sklearn.datasets import make_classification
X,y=make_classification(n_samples=100,n_features=4,n_informative=2,n_redundant=0,
                        random_state=0,shuffle=False)
clf=BaggingClassifier(base_estimator=SVC(),n_estimators=10,random_state=0).fit(X,y)
clf.predict([[0,0,0,0]])
