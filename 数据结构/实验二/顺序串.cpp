//˳�򴮵Ļ�������
#include<iostream>
#include<string.h>
using namespace std;
#define max 50
typedef struct
{
	char data[max];
	int length;
}sqstring;
void display(sqstring s)//�����
{
	int i;
	if(s.length>0)
		for(i=0;i<s.length;i++)
			cout<<s.data[i]<<" ";
		cout<<endl;
}
sqstring rep(sqstring s,int i,int j,sqstring t)//�Ӵ����滻
{
	int k;
	sqstring str;
	str.length=0;
	if(i<=0||i>s.length||i+j-1>s.length)
		return str;
	for(k=0;k<i-1;k++)
		str.data[k]=s.data[k];
	for(k=0;k<t.length;k++)
		str.data[i+k-1]=t.data[k];
	for(k=i+j-1;k<s.length;k++)
		str.data[t.length+k-j]=s.data[k];
	str.length=s.length-j+t.length;
	return str;
}
sqstring strdelete(sqstring s,int i,int j)//�Ӵ���ɾ��
{
	int k;
	sqstring str;
	str.length=0;
	if(i<=0||i>s.length||i+j>s.length+1||j<0)
		return str;
	for(k=0;k<i-1;k++)
		str.data[k]=s.data[k];
	for(k=i+j-1;k<s.length;k++)
		str.data[k-j]=s.data[k];
	str.length=s.length-j;
	return str;
}
sqstring inset(sqstring s1,int i,sqstring s2)//���Ĳ���
{
	int j;
	sqstring str;
	str.length=0;
	if(i<=0||i>s1.length+1)
		return str;
	for(j=0;j<i-1;j++)
		str.data[j]=s1.data[j];
	for(j=0;j<s2.length;j++)
		str.data[i+j-1]=s2.data[j];
	for(j=i-1;j<s1.length;j++)
		str.data[s2.length+j]=s1.data[j];
	str.length=s1.length+s2.length;
	return str;
}
int BF(sqstring s,sqstring t,int pos)//�ڴ�s���ҵ�һ����t�������ش�t�ĵ�һ��Ԫ�ص��±�
{   
	int i = pos;//��ʼ�� 
    int j = 1;
	int lens = s.length;
    int lensub = t.length;
    if(pos<0||pos>s.length)
        return -1;
    while (i <= lens && j <= lensub)//��������Ϊ�Ƚϵ�ĩβ 
    {
        if (s.data[i] == t.data[j])
        {
            ++i;
            ++j;//�����ȽϺ���ַ� 
        }
        else//ָ��������¿�ʼƥ�� 
        {
            i = i - j + 2;
            j = 1;
        }
	}
    if (j > t.length) return i-t.length;
    else return 0;
}
sqstring sub(sqstring s,int i,int j)//���Ӵ�
{
	int k;
	sqstring str;
	str.length=0;
	if(i<=0||i>s.length||j<0||i+j-1>s.length)
		return str;
	for(k=i-1;k<i+j-1;k++)
		str.data[k-i+1]=s.data[k];
	str.length=j;
	return str;
}
sqstring concat(sqstring s,sqstring t)//��������
{
	sqstring str;
	int i;
	str.length=s.length+t.length;
	for(i=0;i<s.length;i++)
		str.data[i]=s.data[i];
	for(i=0;i<t.length;i++)
		str.data[s.length+i]=t.data[i];
	return str;
}
void stringlength(sqstring s)//�󴮵ĳ���
{
	int i=s.length;
	cout<<"���ĳ���Ϊ:"<<i<<endl;
}
void copy(sqstring&s,sqstring t)//���ĸ���
{
	int i;
	for(i=0;i<t.length;i++)
		s.data[i]=t.data[i];
	s.length=t.length;
}
bool equal(sqstring s,sqstring t)//�жϴ��Ƿ����
{
	bool same=true;
	int i;
	if(s.length!=t.length)
		same=false;
	else
		for(i=0;i<s.length;i++)
			if(s.data[i]!=t.data[i])
			{
				same=false;
				break;
			}
			return same;
}
void destroy(sqstring&s)//���ٴ�
{
}
void create(sqstring&s,char a[])//���ɴ�
{
	int i;
	for(i=0;a[i]!='\0';i++)
		s.data[i]=a[i];
	s.length=i;
}

int main()
{
	sqstring s;
	sqstring sl;
	sqstring t;
	sqstring s2;
	sqstring s3;
	sqstring s4;
	char a[max],b[max];
	cout<<"input string s:";
	cin>>a;
	create(s,a);
	cout<<"inout string sl:";
	cin>>b;
	create(sl,b);
	create(t,b);
    int index=BF(s,t,0);
	cout<<"��sΪ:";
	display(s);
	cout<<"s�ĳ���Ϊ:";
	stringlength(s);
    
    
	cout<<"��s�ĵھŸ�λ�ò��봮sl:";
	s2=inset(s,9,sl);
	display(s2);
 
	cout<<"ɾ����s�ĵ�2���ַ���ʼ��5���ַ���";
	s2=strdelete(s,2,5);
	display(s2);
	cout<<"ɾ���󴮵ĳ���Ϊ:";
	stringlength(s2);
 
	cout<<"��s�ĵڶ����ַ���ʼ������ַ��滻��sl��";
	s2=rep(s,2,5,sl);
	display(s2);
	cout<<"s�ĵڶ����ַ���ʼ�ĵ�ʮ���ַ���";
	 s3=sub(s,2,10);
	display(s3);
	cout<<"sl��s2���Ӻ�";
	 s4=concat(sl,s2);
	display(s4);
	return 0;
}
