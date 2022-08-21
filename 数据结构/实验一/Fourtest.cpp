#include <stdio.h>
#include <stdlib.h>
#include <iostream.h>
struct student
{
	int id;
	char name[20];
	char sex[2];
	int age;
};
struct llist                       /* ����ṹ����      */
{
   struct student num;                        /* ������          */
   struct llist *next;             /* ָ����      */
};
typedef struct llist node;         /* �����ض���   */
typedef node *llink;               /* �ض���ָ������   */
/*�D�D�D�D�D�D�D�D�D�D�D�D���������D�D�D�D�D�D�D�D�D�D�D�D*/
void printllist(llink head)
{
   llink ptr;
   ptr = head->next;              /*  ָ����������ʼ   */
   while ( ptr != NULL )          /*  �������ѭ��     */
   {
      printf("[%d,%s,%s,%d]",ptr->num.id,ptr->num.name,ptr->num.sex,ptr->num.age);    /*  ����������    */
	  printf("\n");
      ptr = ptr->next;            /*  ָ����һ���    */
   }
   printf("\n");                  /*  ����           */
}
/*�D�D�D�D�D�D�D�D�D�D�D�D����Ĵ����D�D�D�D�D�D�D�D�D�D�D�D*/
llink Initllist(llist &L)
{
   llink head;                     /*  ����Ŀ�ʼָ��   */
   /* ������ͷ��� */
   head = ( llink ) malloc(sizeof(node));  /*  �����ڴ�  */
   if ( !head )                       /*    ���ָ��      */
      return NULL;
   head->num.id=0;
   head->next=NULL;
   return head;
}
/*�D�D�D�D�D�D�D�D�D�D�D�D����Ľ�����D�D�D�D�D�D�D�D�D�D�D*/
llink insertnode(llink head, student S)
{
   int i;
   int j;
   llink ptr;
   llink ptr1;
   llink mnew;                      /* �½��ָ�����    */
   mnew = ( llink ) malloc(sizeof(node));  /* �����½�� */
   if ( !mnew )
      return NULL;

   mnew->num = S;              /* �����������      */
   mnew->next = NULL;              /* �趨ָ���ֵ      */
   /* ���ptr���ͷ�ڵ����ǲ����һ����� */
   i=S.id;
   ptr1=head;
   ptr=head->next;
   for(j=1;j<=head->num.id;j++)
   {
	   if(ptr->num.id<i){ptr1=ptr;ptr=ptr->next;}
   }
   mnew->next=ptr1->next;
   ptr1->next=mnew;
   head->num.id++;
   return head;
}
/*�D�D�D�D�D�D�D�D�D�D�D�D����Ľ��ɾ���D�D�D�D�D�D�D�D�D�D�D��*/
llink deletenode(llink head,int i)
{
   llink previous;
   llink deleteptr;
   llink ptr;
   deleteptr=head;
   previous=head;
   ptr = head->next;
   if(!ptr){printf("�ձ�\n");return head;};
   while(ptr->num.id!= i){
	   previous=ptr;
	   ptr = ptr->next;
       if(!ptr){
		   printf("�޸�ѧ�ţ�\n");
		   return head;
	   }
   }
   deleteptr=previous->next;
   previous->next=previous->next->next;
   free(deleteptr);
   head->num.id--;
   return head;
}
/*�D�D�D�D�D�D�D�D�D�D�D�D�D������D�D�D�D�D�D�D�D�D�D�D*/
void main()
{
   char flag;
   char flag1;
   int a;
   char b[20];
   char c[2];
   int d;
   int deleteid;
   int i;
   student s1;
   llist llist1;
   llink head;                          /* ָ������ʼ      */
   head = Initllist(llist1);       /* ��������         */
   if ( !head )
   {
      printf("�ڴ����ʧ��! \n");
      exit(1);
   }
   printf("ԭ��������: ");
   printllist(head);               /* ���ԭ������      */
   printf("�����½��?Y?N?\n");
   cin>>flag;
   while(flag=='Y'){
	   printf("����ѧ����Ϣ:\n");
	   cin>>a>>b>>c>>d;
	   s1.id=a;
	   for(i=0;i<20;i++){
		   s1.name[i]=b[i];
	   }
	   for(i=0;i<2;i++){
		   s1.sex[i]=c[i];
	   }
	   s1.age=d;
	   head = insertnode(head, s1); /* �����½��      */
	   if ( !head )
	   {
		  printf("�ڴ����ʧ��! \n");
		  exit(1);
	   }
      printf("��ǰ������: ");
	   printllist(head); 
	   printf("�����½��?Y?N?\n");
	   cin>>flag;
   }

   /* ɾ�����ڽ�� */
   printf("ɾ�����?Y?N?\n");
   cin>>flag1;
   while(flag1=='Y'){
	   printf("����ѧ��:");
	   scanf("%d",&deleteid);
	   head = deletenode(head,deleteid);
	   printf("��ǰ������: ");
	   printllist(head); 
	   printf("ɾ�����?Y?N?\n");
	   cin>>flag1;
   }

   printf("��������: ");
   printllist(head);              /*    ������    */
}

