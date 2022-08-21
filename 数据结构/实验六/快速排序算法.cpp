#include <stdio.h>
#include <stdlib.h>
#define N 8
 
typedef struct {
	char name[5];  //���� 
	int score;   //�ɼ�
}stu;

int Partition(stu sc[N+1], int low, int high) {
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
}

void QSort(stu sc[N+1], int low, int high) {
  //��˳���L�е�������L.r[low..high]���п�������
  int pivotloc;
  if (low < high) {                      // ���ȴ���1
    pivotloc = Partition(sc, low, high);  // ��sc[low..high]һ��Ϊ��
    QSort(sc, low, pivotloc-1);  //�Ե��ӱ�ݹ�����pivotloc������λ��
    QSort(sc, pivotloc+1, high);          // �Ը��ӱ�ݹ�����
  }
} 

int main(){
	stu sc[N+1];//��¼0���ڱ�,�൱��tmp  
	for(int i = 1;i<=N;i++){
		printf("�������%d��ѧ��������:",i);
		scanf("%s",&sc[i].name);
		sc[i].score = 1+rand()%100;		 
	}		
	printf("����Щ¼���ѧ��������ɳɼ�\n������£�\n");
	for(int i = 1;i<=N;i++)
		printf("record %2d:name =%5s  score = %2d\n",i,sc[i].name,sc[i].score);
	QSort(sc,1,N);//�������� 
	printf("\n------>���������<------\n");
	for(int i = N,j=1;i>=1,j<=N;i--,j++)
		printf("���� %2d:name =%5s  score = %2d \n",j,sc[i].name,sc[i].score);	
} 
