#include<iostream>
using namespace std;
typedef struct BiNode{				//����������
	char data;
	struct BiNode *lchild,*rchild;
}BiTNode,*BiTree;

//���㷨5.3 ���������˳������������
void CreateBiTree(BiTree &T){	
	//�������������������н���ֵ��һ���ַ������������������ʾ�Ķ�����T
	char ch;
	cin >> ch;
	if(ch=='#')  T=NULL;			//�ݹ������������
	else{							
		T=new BiTNode;
		T->data=ch;					//���ɸ����
		CreateBiTree(T->lchild);	//�ݹ鴴��������
		CreateBiTree(T->rchild);	//�ݹ鴴��������
	}								//else
}									//CreateBiTree

void frontOrderTraverse(BiTree T){  
	//ǰ�����������T�ĵݹ��㷨
	if(T){
		cout << T->data;
		frontOrderTraverse(T->lchild);	
		frontOrderTraverse(T->rchild);
	}
}

void backOrderTraverse(BiTree T){  
	//�������������T�ĵݹ��㷨
	if(T){
		backOrderTraverse(T->lchild);
		backOrderTraverse(T->rchild);
		cout << T->data;
	}
}

void InOrderTraverse(BiTree T){  
	//�������������T�ĵݹ��㷨
	if(T){
		InOrderTraverse(T->lchild);
		cout << T->data;
		InOrderTraverse(T->rchild);
	}
}

int main(){
	BiTree tree;
	cout<<"�����뽨��������������У�\n";
	CreateBiTree(tree);
	cout<<"ǰ������Ľ��Ϊ��\n";
	frontOrderTraverse(tree);
	cout<<"\n��������Ľ��Ϊ��\n";
	InOrderTraverse(tree);	
	cout<<"\n����������Ľ��Ϊ��\n";
	backOrderTraverse(tree);
	cout<<endl;
}
//�������ݣ�ABC##DE#G##F###
