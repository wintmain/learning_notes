#include <iostream.h>
#include <iomanip.h>
#define N 10
struct studscore
{
	char name[10];
	int score;
};
void BInsertSort(studscore sc[N+1]);
void main()
{
	char a[10];
	int b;
	studscore sc[N+1];
	cout<<"������"<<N<<"��ѧ�����������ɼ���"<<'\n';
	for (int i=1;i<=N;i++){
		cin>>a>>b;
		for(int j=0;j<10;j++){
		   sc[i].name[j]=a[j];
	   }
		sc[i].score=b;
	}
	cout<<"�������"<<N<<"��ѧ���������Ӹߵ�������"<<'\n';
	BInsertSort(sc);
	for(i=1;i<=N;i++){
		cout<<setw(10)<<sc[i].name<<setw(6)<<sc[i].score<<'\n';
	}
}

void BInsertSort(studscore sc[N+1]) {  // �㷨
  // ���������۰��������
  int i,j,high,low,m;
  for (i=2; i<=N; ++i) {
    sc[0] = sc[i];       // ��sc[i]�ݴ浽sc[0]
    low = 1;   high = i-1;
    while (low<=high) {    // ��sc[low..high]���۰������������λ��
      m = (low+high)/2;                            // �۰�
      if (sc[0].score<sc[m].score) high = m-1;  // ������ڵͰ���
      else  low = m+1;                             // ������ڸ߰���
    }
    for (j=i-1; j>=high+1; --j) {
		sc[j+1]=sc[j];
	}// ��¼����
    sc[high+1]=sc[0]; // ����
  }
} // BInsertSort
