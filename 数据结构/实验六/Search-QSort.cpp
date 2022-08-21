#include <iostream.h>
#include <iomanip.h>
#define N 10
struct studscore
{
	char name[10];
	int score;
};
void QSort(studscore sc[N+1], int low, int high);

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
	QSort(sc,1,N);
	for(i=1;i<=N;i++){
		cout<<setw(10)<<sc[i].name<<setw(6)<<sc[i].score<<'\n';
	}
}
int Partition(studscore sc[N+1], int low, int high) {  // �㷨
   // ����˳���L��������sc[low..high]�ļ�¼��ʹ�����¼��λ��
   // ������������λ�ã���ʱ������֮ǰ���󣩵ļ�¼������С������
   int pivotkey;
   sc[0] = sc[low];            // ���ӱ�ĵ�һ����¼�������¼
   pivotkey = sc[low].score;      // �����¼�ؼ���
   while (low<high) {            // �ӱ�����˽�������м�ɨ��
      while (low<high && sc[high].score>=pivotkey) --high;
      sc[low] = sc[high];      // ���������¼С�ļ�¼�Ƶ��Ͷ�
      while (low<high && sc[low].score<=pivotkey) ++low;
      sc[high] = sc[low];      // ���������¼��ļ�¼�Ƶ��߶�
   }
   sc[low] = sc[0];            // �����¼��λ
   return low;                   // ��������λ��
} // Partition
void QSort(studscore sc[N+1], int low, int high) {  //�㷨
  // ��˳���L�е�������L.r[low..high]���п�������
  int pivotloc;
  if (low < high) {                      // ���ȴ���1
    pivotloc = Partition(sc, low, high);  // ��sc[low..high]һ��Ϊ��
    QSort(sc, low, pivotloc-1); // �Ե��ӱ�ݹ�����pivotloc������λ��
    QSort(sc, pivotloc+1, high);          // �Ը��ӱ�ݹ�����
  }
} // QSort

