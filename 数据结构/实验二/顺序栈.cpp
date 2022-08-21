#include<stdio.h>
#include<stdlib.h>
#define MAXSIZE 100 //˳��ջ����ռ�ĳ�ʼ������
#define SIZEINCREMENT 10

typedef int SelemType;
typedef int Status;

typedef struct{ //˳��ջ�Ķ���
	SelemType *base; //ջ��ָ�� 
	SelemType *top; //ջ��ָ�� 
	int stacksize; //ջ���õ�������� 
}sqstack;

Status initstack(sqstack &S){
	//����һ����ջS
	S.base=(SelemType *)malloc(MAXSIZE*sizeof(SelemType));
	if(!S.base)  exit(-1);
	S.top=S.base;
	S.stacksize=MAXSIZE;
	return 1;
}

Status Push(sqstack &S,SelemType e){
	//����Ԫ��eΪ�µ�ջ��Ԫ��
	if(S.top-S.base>=S.stacksize){
	 S.base=(SelemType *)realloc(S.base,(S.stacksize+SIZEINCREMENT)*sizeof(SelemType));
	 if(!S.base) return -1;
	 S.top=S.base+S.stacksize;
	 S.stacksize+=SIZEINCREMENT;
	}
	*S.top++=e;
	return 1; 
}

Status Pop(sqstack &S, SelemType &e){
	//ɾ��S��ջ��Ԫ�أ���e������ֵ
	if(S.top==S.base) 
		return -1;
	e=*--S.top;
	printf("ɾ����ջ��Ԫ���ǣ�%d\n",e);
	return 1;  
}

Status Gettop(sqstack S){
	//����S��ջ��Ԫ�أ����޸�ջ��ָ��
	if(S.top!=S.base)
	printf("ջ��Ԫ���ǣ�%d\n",*(S.top-1));
	return 1;
} 

Status show_stack(sqstack &S){
	SelemType *i;
	if(S.top==S.base) return -1;
	for (i=S.base;i<S.top;i++){
		printf("%d ",*i);
	}
return 1;
}

int main(void){
	int i,m,flag;
	SelemType e;
	printf("������˳��ջ��Ԫ�صĸ���\n");
	scanf("%d",&m);
	sqstack S;
	initstack(S);
	for (flag = 0,i=1; flag<m; flag++,i=i+3){
		Push(S,i);
}
printf("ջ��Ԫ���ǣ�\n");
show_stack(S);
printf("\n");
Gettop(S);
Pop(S,e);
printf("��ʱ��ջ��Ԫ����\n");
Gettop(S);
}

