#include<stdio.h>
#include<stdlib.h> 

typedef char ElemType;
typedef char Status;
typedef struct QNode{
ElemType data;
struct QNode *next; //ָ���� 
}Qnode,*Queueptr;
typedef struct{
Queueptr front; //��ͷָ�� 
Queueptr rear; //��βָ�� 
}LinkQueue;

Status initqueue(LinkQueue &Q){
	Q.front=Q.rear=new Qnode;
	Q.front->next=NULL;
	return 1;
}

Status EnQueue(LinkQueue &Q,ElemType e)   //���
{
    Queueptr p;
    p=new QNode;
    p->data=e;
    p->next=NULL;
    Q.rear->next=p;     //���½����뵽��β
    Q.rear=p;           //�޸Ķ�βָ��
    return 1;
}
 
Status DeQueue(LinkQueue &Q,ElemType &e)    //����
{
    Queueptr p;
    if(Q.front==Q.rear) return -1;
    p=Q.front->next;        //ɾ����ͷԪ��
    e=p->data;
    Q.front->next=p->next;      //�޸�ͷ����ָ����
    if(Q.rear==p) Q.rear=Q.front;   //������һ��Ԫ�ر�ɾ����βָ��ָ��ͷ���
    delete p;               //�ͷ�ԭ��ͷԪ�صĿռ�
    return 1;
}
 
Status GetHead(LinkQueue Q)
{
    if(Q.front!=Q.rear)
        return Q.front->next->data;
}

int main()
{
    LinkQueue Q;
    initqueue(Q);
    int i;
    printf("��Ԫ�����: ");
    for(i=0;i<5;i++)
    {   
		char j;
        scanf("%c",&j);
        EnQueue(Q,j);
    }
    char k;
    DeQueue(Q,k);
    printf("����1λ��");
    printf("%c",k);
    DeQueue(Q,k);
    printf("�ٳ���1λ��");
    printf("%c",k);
    printf("ȡ��ͷԪ�أ�");
    printf("%c",GetHead(Q));
    return 0;
}
