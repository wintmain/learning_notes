#include<stdio.h>
int matrix[6][6];//��������ͼ������ڽ�����
void creategraph(int *node,int num) {//����ͼ�� 
   int from;//���ߵ����
   int to;//���ߵ��յ�
   int i;
   for(i=0;i<num;i++) {//��ȡ���ߵĻ�·
      from = node[i*2];//���ߵ����
      to = node[i*2+1];//���ߵ��յ�
      matrix[from][to] = 1;//����ͼ��
   }
}
int main(){
   int node[12][2]={ {0,2}, {2,0}, //��������
                    {1,4}, {4,1},
                    {1,5}, {5,1},
                    {3,4}, {4,3},
                    {3,5}, {5,3},
                    {4,5}, {5,4} };
   int i,j;
   for(i=0;i<=5;i++)
      for(j=0;j<=5;j++)
	 matrix[i][j]=0;    //���ͼ���ڽ�����
   creategraph(*node,12);       //����ͼ��  
   printf("ͼ�ε��ڽ���������:\n");
   for (i=0;i<=5;i++)
   {
      for (j=0;j<=5;j++)
         printf(" %d ",matrix[i][j]);//����������� 
      printf("\n");
   }
}




