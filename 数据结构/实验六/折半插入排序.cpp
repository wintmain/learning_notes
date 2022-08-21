#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 10
 
typedef struct{
	char name[5];  //���� 
	int score;   //�ɼ�
}record;
 
typedef struct{
	record rec[MAXSIZE+1]; //����MAXSIZE+1����¼,��¼0���ڱ�,�൱��tmp 
	int length;           //˳���ĳ��� 
}sqList;
 
int main(){
	sqList L; 
	L.length = MAXSIZE; 
	for(int i = 1;i<=L.length;i++){
		printf("�������%d��ѧ��������:",i);
		scanf("%s",&L.rec[i].name);
		L.rec[i].score = 1+rand()%100;		 
	}		
	printf("����Щ¼���ѧ��������ɳɼ�\n������£�\n");
	//�������ǰ�ļ�¼
	for(int i = 1;i<=L.length;i++)
		printf("record %2d:name =%5s  score = %2d\n",i,L.rec[i].name,L.rec[i].score);
			
	//�۰��������;�ؼ�������,i�ӵ�2����¼��ʼ�Ƚ� 
	for(int i = 2;i<=L.length;i++){
		int low = 1,mid,high = i-1;
		L.rec[0] = L.rec[i];         //��L.rec[i]�ݴ浽L.rec[0]
		while(low<=high){			//�۰���Ҵ������λ��; 
			mid = (low + high)/2;  //�۰�  
			if(L.rec[mid].score<L.rec[0].score)
				low = mid + 1;   //������ڸ߰��� 
			else 
				high = mid - 1; //������ڵͰ��� 
		}//�˳�whileѭ��ʱhigh֮��ĵ�ԪΪ������ĵ�Ԫ 
		for(int j = i-1;j>=low;--j)    //���߽�low����high+1 
			L.rec[j+1] = L.rec[j];//��¼����
		L.rec[low] = L.rec[0];        //������߽�low����high+1 
	} 
	//��������ļ�¼ 
	printf("\n------>�۰���������<------\n");
	for(int i = L.length,j=1;i>=1,j<=L.length;i--,j++)
		printf("���� %2d:name =%5s  score = %2d \n",j,L.rec[i].name,L.rec[i].score);	
} 
