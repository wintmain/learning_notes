#include<stdio.h>
#include<string.h>

void shift(char *p,long m,int n)    
{
    int r;
    while (m>0)
    {
        r = m%n;			//����
        if (r<10)
        {
            *p=r+48;    //С��10����ת�����ַ��󸳸�P��ָ���Ԫ��
        }
        else
        {
            *p=r+55;	//10-15ת��Ϊ��A~F���󸳸�P��ָ���Ԫ��
        }
        m=m/n;
        p++; 				//ָ�����

    }
    *p = '/0';
}
int main(void)
{
    int x;
    long y;
    char a[32] = {};		//��Ž��������
    L:
    printf("����Ҫת���Ľ�����:"); 
    scanf("%d", &x);
    if (x <= 0)
    {
        printf("�����������������룡\n");
        goto L;
    }
    else
    {
        printf("��������Ҫ��ת����ʮ��������");
        scanf("%ld", &y);
        printf("\n");
        printf("%dת��Ϊ%d������Ϊ��",y,x);
        shift(a,y,x);
        for (int i=strlen(a)-1;i>=0;i--)    //��������ַ���
        {
            printf("%c",*(a+i));         		//*(a+i)��a[i];
        }
    }
    printf("\n");
    return 0;
}

