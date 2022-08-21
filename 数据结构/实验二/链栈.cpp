#include<stdio.h>
#include<stdlib.h>

typedef int SelemType;
typedef int Status;

typedef struct sqstack{ 
	SelemType data; 
    struct sqstack *next;
}sqstack,*LinkStack;

Status initstack(LinkStack &S){
	//����һ����ջS,ջ��ָ���ÿ�
	S = NULL;
	return 1;
}

Status Push(LinkStack &S,SelemType e){
	//����Ԫ��eΪ�µ�ջ��Ԫ��
	LinkStack p;
	p = new sqstack; //�����½��
	p->data = e; //���½����������Ϊe
	p->next = S; //���½�����ջ��
	S = p; //�޸�ջ��ָ��Ϊp
	return e; 
}

Status Pop(LinkStack &S,SelemType &e){
	//ɾ��S��ջ��Ԫ�أ���e������ֵ
	LinkStack p;
	if (S == NULL)
		return 0; //ջ��
	e = S->data; //��ջ��Ԫ�ظ���e
	p = S; //��p��ʱ����ջ��Ԫ�ؿռ䣬�Ա��ͷ�
	S = S->next; //�޸�ջ��ָ��
	delete p; //�ͷ�ԭջ��Ԫ�صĿռ�
	//printf("ɾ����ջ��Ԫ���ǣ�%d\n",e);
	return 1;  
}

Status Gettop(LinkStack S){
	//����S��ջ��Ԫ�أ����޸�ջ��ָ��
	if (S != NULL) //ջ�ǿ�
		return S->data; //����ջ��Ԫ�ص�ֵ��ջ��ָ�벻��
	printf("ջ��Ԫ���ǣ�%d\n",S->next->data);
	return 1;
} 

/*Status show_stack(sqstack &S){
	SelemType *i;
	if(S.top==S.base) return -1;
	for (i=S.base;i<S.top;i++){
		printf("%d ",*i);
	}
return 1;
}*/ 

int main(){
	int i,m,flag;
	SelemType e;
	printf("��������ջ��Ԫ�صĸ���\n"); 
	scanf("%d",&m);
	LinkStack S;
	initstack(S);
	printf("ջ��Ԫ���ǣ�\n");
	for (flag = 0,i=1; flag<m; flag++,i=i+3){
		printf("%d ",Push(S,i));
}

//show_stack(S);
printf("\n");
printf("ջ��Ԫ���ǣ�%d",Gettop(S));
Pop(S,e);
printf("\n");
printf("ɾ��ջ��Ԫ�غ����ڵ�ջ��Ԫ���ǣ�%d",Gettop(S));
}

