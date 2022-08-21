#include<stdlib.h>
#include<stdio.h>
typedef struct tree
{ 
int data;
struct tree *left;
struct tree *right;
}treenode,*btree;
/*---------------------������----------------------*/
btree insertnode(btree root,int value){  
 btree newnode;  /* ��ָ�� */
 btree current;  /* ��ǰ���ָ�� */
 btree back;     /* �����ָ�� */
 /* ��������ڴ� */
 newnode=(btree)malloc(sizeof(treenode)); 
 newnode->data=value;
 newnode->left=NULL;
 newnode->right=NULL;
 if(root==NULL)//��������Ϊ�գ��ͷ����²���Ľ�� 
   {
    return newnode;
   }
 else//���ڵ㲻Ϊ�յ������ 
   {
    current=root;
    while(current!=NULL)
    {
	 back=current;
     if(current->data>value)//�Ƚ�ֵ�Ĵ�С���������������С������ 
       current=current->left;
     else
       current=current->right;
    }
   if(back->data>value)
    back->left=newnode;
  else
    back->right=newnode;
  }
return root;
}
/*------------------����������----------------*/
btree createbtree(int *data,int len)
{   
btree root=NULL;
int i;
for(i=0;i<len;i++)
root=insertnode(root,data[i]);
return root;
}
/*------------------�������������----------------*/
void inorder(btree ptr)
{  
if(ptr!=NULL){  
 inorder(ptr->left);
 printf("[%2d]\n",ptr->data);
 inorder(ptr->right);}
}
/*------------------������---------------------*/
int main()
{  
btree root=NULL;
int data[9]={5,6,4,8,2,3,1,7,9};
root=createbtree(data,9);
printf("��������:\n");
inorder(root);
printf("\n\n����һ��ֵΪ-5�Ľ�㣺\n");
insertnode(root,-5);
inorder(root);
}

