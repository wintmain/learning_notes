#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct Queue{
    int Front;
    int Rear;
    char elem[100][100];
    int Queuesize;
}Queue;
 
void Creat_Queue(Queue &Q)
{//����һ������
    int n,i;
    Q.Front=Q.Rear=0;
    printf("��������������:");
    scanf("%d",&n);
    Q.Queuesize=n+1;
    printf("�����������������");
    for(i=0;i<n;i++)
        scanf("%s",&Q.elem[i]);
    Q.Rear=n;
}
 
int QueueEmpty(Queue Q)
{//�ж϶����Ƿ�Ϊ��
    if(Q.Front==Q.Rear)
        return 1;
    else
        return 0;
}
void DeQueue(Queue &Q,char *str)
{//ɾ����ͷԪ��
    strcpy(str,Q.elem[Q.Front]);
    Q.Front=(Q.Front+1)%Q.Queuesize;
}
void GetQueue(Queue Q,char *str)
{//ȡ����Ԫ�أ���ͷָ�벻�ı�
    strcpy(str,Q.elem[Q.Front]);
}
 
void Judge_Queue(Queue &M,Queue &W)
{//������
    int n;
    char str1[100],str2[100];
    printf("����������������");
    scanf("%d",&n);
    while(n--)
    {
        while(!QueueEmpty(M))
        {
            if(QueueEmpty(W))
                DeQueue(W,str1);
            DeQueue(M,str1);
            DeQueue(W,str2);
            printf("��Ե����ߣ�%s %s\n",str1,str2);
        }
        M.Front=(M.Front+1)%M.Queuesize;
        if(QueueEmpty(W))
                DeQueue(W,str1);
        GetQueue(W,str1);
        printf("��һ��������δ����ߵ�������%s\n",str1);
    }
}
 
int main()
{
    Queue M,W;
    printf("�жӣ�\n");
    Creat_Queue(M);
    printf("Ů�ӣ�\n");
    Creat_Queue(W);
    if(M.Queuesize>W.Queuesize)
        Judge_Queue(W,M);
    else
        Judge_Queue(M,W);
 
    return 0;
}
