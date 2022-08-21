#include<stdio.h>
#include<stdlib.h>

typedef struct Bnode{
	int data;//���������
	Bnode *lchild,*rchild;//���Һ���ָ��
}Bnode,*Btree;

void insert_tree(Btree &T,int a){
//������������T�в�����ֵ����a������Ԫ��ʱ��������Ԫ��
	Btree S;
	if(!T){//�ҵ�����λ�ã��ݹ����
		S=new Bnode; //�����½��*S
		S->data=a;//�½��*S����������Ϊa
		S->lchild=S->rchild=NULL;//�½��*S��ΪҶ�ӽ��
		T=S;	//���½��*S���ӵ����ҵ��Ĳ���λ��
	}
	else if(a<T->data)
		insert_tree(T->lchild,a);//��*S����������
	else if(a>T->data)
		insert_tree(T->rchild,a);//��*S����������
}

void creat_tree(Btree &T){
//���ζ���һ���ؼ���Ϊa�Ľ�㣬���˽��������������T��
	T=NULL;
	int a;
	scanf("%d",&a);
	while(a!=0){
		insert_tree(T,a);//���˽��������������T��
		scanf("%d",&a);
	}
}

Btree search(Btree T,int key){
//�ڸ�ָ��T��ָ�����������еݹ�ز���ĳ�ؼ��ֵ���key������Ԫ��
//�����ҳɹ����򷵻�ָ�������Ԫ�ؽ���ָ�룬���򷵻ؿ�ָ��
	if((!T)||key==T->data) return T;//���ҽ���
	else if(key<T->data) return search(T->lchild,key);//���������м�������
	else return search(T->rchild,key);//���������м�������
}

void InOrderTraverse(Btree &T){//������� 
	if(T){
	InOrderTraverse(T->lchild);
	printf("%d ",T->data);
	InOrderTraverse(T->rchild);
	}
}

int main(){
	int m;
	Btree T;
	printf("�����������������ûس����֣���0��������\n");
	creat_tree(T);
	printf("��ǰ�������������������Ϊ\n");
	InOrderTraverse(T);
	printf("\n��������Ҫ���ҵ���:");
	scanf("%d",&m);
	Btree result=search(T,m); 
	if(result)
		printf("�������������и���");
	else
		printf("δ�ҵ�");
		
}
