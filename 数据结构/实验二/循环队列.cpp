#include<stdio.h>
#include<stdlib.h> 
#define MAXQSIZE 100

typedef char QElemType;
typedef char SElemType;
typedef int Status;

typedef struct {
	QElemType *base;//��ʼ��ʱ��̬����洢�ռ�
	int front;//ͷָ��
	int rear;//βָ��
} SqQueue;

//ѭ�����еĳ�ʼ��
Status InitQueue(SqQueue &Q) {//����һ���ն���Q
	Q.base = new QElemType[MAXQSIZE]; //Ϊ���з���һ���������ΪMAXSIZE������ռ�
	if (!Q.base)
		exit(-2); //�洢����ʧ��
	Q.front = Q.rear = 0; //ͷָ���βָ����Ϊ�㣬����Ϊ��
	return 1;
}

//��ѭ�����еĳ���
int QueueLength(SqQueue Q) {//����Q��Ԫ�ظ����������еĳ���
	return (Q.rear - Q.front + MAXQSIZE) % MAXQSIZE;
}

//ѭ�����е����
Status EnQueue(SqQueue &Q, QElemType e) {//����Ԫ��eΪQ���µĶ�βԪ��
	if ((Q.rear + 1) % MAXQSIZE == Q.front) //βָ����ѭ�������ϼ�1�����ͷָ�룬��������
		return 0;
	Q.base[Q.rear] = e; //��Ԫ�ز����β
	Q.rear = (Q.rear + 1) % MAXQSIZE; //��βָ���1
	return 1;
}

//ѭ�����еĳ���
Status DeQueue(SqQueue &Q, QElemType &e) {//ɾ��Q�Ķ�ͷԪ�أ���e������ֵ
	if (Q.front == Q.rear)
		return 0; //�ӿ�
	e = Q.base[Q.front]; //�����ͷԪ��
	Q.front = (Q.front + 1) % MAXQSIZE; //��ͷָ���1
	return 1;
}

//ȡѭ�����еĶ�ͷԪ��
SElemType GetHead(SqQueue Q) {//����Q�Ķ�ͷԪ�أ����޸Ķ�ͷָ��
	if (Q.front != Q.rear) //���зǿ�
		return Q.base[Q.front]; //���ض�ͷԪ�ص�ֵ����ͷָ�벻��
}

int main(){
	SqQueue Q;
	int i;
	InitQueue(Q);
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
