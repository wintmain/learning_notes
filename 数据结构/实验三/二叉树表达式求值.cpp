#include <stdio.h>
#include <string.h>
#include <malloc.h>
#include<stdlib.h> 
#define MaxSize 100

typedef char ElemType;
typedef struct node
{
    ElemType data;              //����Ԫ��
    struct node *lchild;        //ָ������
    struct node *rchild;        //ָ���Һ���
} BTNode;


//��s[i]��s[j]֮����ַ���������������ı�ʾ��ʽ
BTNode *CRTree(char s[],int i,int j)
{
    BTNode *p;
    int k,plus=0,posi;
    if (i==j)    //i��j��ͬ����ζ��ֻ��һ���ַ����������һ��Ҷ�ӽڵ�
    {
        p=(BTNode *)malloc(sizeof(BTNode));   //����洢�ռ�
        p->data=s[i];                         //ֵΪs[i]
        p->lchild=NULL;
        p->rchild=NULL;
        return p;
    }
    //����Ϊi!=j�����
    for (k=i; k<=j; k++)
        if (s[k]=='+' || s[k]=='-')
        {
            plus++;
            posi=k;              //���һ��+��-��λ��
        }
    if (plus==0)                 //û��+��-�����(��Ϊ����+��-��ǰ��ػ�ִ��plus++)
        for (k=i; k<=j; k++)
            if (s[k]=='*' || s[k]=='/')
            {
                plus++;
                posi=k;
            }
    //���ϵĴ����������Ƚ�+��-�ŵ��������ϸߵĲ����
    //���ڽ�������ʱ�����õ��Ǻ��������˼·
    //���ڽϵͲ�ĳ˳�����������
    //�Ӷ������ˡ��ȳ˳���Ӽ��������㷨��
    //����һ����֧�ڵ㣬�ü�⵽���������Ϊ�ڵ�ֵ
    if (plus!=0)
    {
        p=(BTNode *)malloc(sizeof(BTNode));
        p->data=s[posi];                //�ڵ�ֵ��s[posi]
        p->lchild=CRTree(s,i,posi-1);   //��������s[i]��s[posi-1]����
        p->rchild=CRTree(s,posi+1,j);   //��������s[poso+1]��s[j]����
        return p;
    }
    else       //��û���κ������������NULL
        return NULL;
}

double Comp(BTNode *b)
{
    double v1,v2;
    if (b==NULL)
        return 0;
    if (b->lchild==NULL && b->rchild==NULL)  //Ҷ�ӽڵ㣬Ӧ����һ�������ַ�������Ŀδ���ǷǷ����ʽ��
        return b->data-'0';    //Ҷ�ӽڵ�ֱ�ӷ��ؽڵ�ֵ������б���������õ����ַ���ʽ������Ҫ-'0'
    v1=Comp(b->lchild); //�ȼ���������
    v2=Comp(b->rchild); //�ټ���������
    switch(b->data)     //��������������Ľ���ٽ������㣬���õ��Ǻ��������˼·
    {
    case '+':
        return v1+v2;
    case '-':
        return v1-v2;
    case '*':
        return v1*v2;
    case '/':
        if (v2!=0)
            return v1/v2;
        else
            abort();
    }
}
void DispBTNode(BTNode *b)  //�����ű�ʾ�����������
{
    if (b!=NULL)
    {
        printf("%c",b->data);
        if (b->lchild!=NULL || b->rchild!=NULL)
        {
            printf("(");
            DispBTNode(b->lchild);
            if (b->rchild!=NULL) printf(",");
            DispBTNode(b->rchild);
            printf(")");
        }
    }
}
void DestroyBTNode(BTNode *&b)   //���ٶ�����
{
    if (b!=NULL)
    {
        DestroyBTNode(b->lchild);
        DestroyBTNode(b->rchild);
        free(b);
    }
}

int main()
{
    BTNode *b;
    char s[MaxSize]="3+2*8-4/5";
    printf("�������ʽ%s\n",s);
    b=CRTree(s,0,strlen(s)-1);
    printf("��Ӧ������:");
    DispBTNode(b);
    printf("\n���ʽ��ֵ:%g\n",Comp(b));
    DestroyBTNode(b);
    return 0;
}
