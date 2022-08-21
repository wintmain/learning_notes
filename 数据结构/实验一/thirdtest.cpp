#include <stdio.h>
#include <stdlib.h>
struct llist                       /* ����ṹ����      */
{
   int num;                        /* ������          */
   struct llist *next;             /* ָ����      */
};
typedef struct llist node;         /* �����ض���   */
typedef node *llink;               /* �ض���ָ������   */
/*�D�D�D�D�D�D�D�D�D�D�D�D���������D�D�D�D�D�D�D�D�D�D�D�D*/
void printllist(llink head)
{
   llink ptr;
   ptr = head;              /*  ָ����������ʼ   */
   while ( ptr != NULL )          /*  �������ѭ��     */
   {
      printf("[%d]",ptr->num);    /*  ����������    */
      ptr = ptr->next;            /*  ָ����һ���    */
   }
   printf("\n");                  /*  ����           */
}
/*�D�D�D�D�D�D�D�D�D�D�D�D����Ĵ����D�D�D�D�D�D�D�D�D�D�D�D*/
llink createllist(int *array,int len)
{
   llink head;                     /*  ����Ŀ�ʼָ��   */
   llink ptr,ptr1;
   int i;
   /* ������ͷ��� */
   head = ( llink ) malloc(sizeof(node));  /*  �����ڴ�  */
   if ( !head )                       /*    ���ָ��      */
      return NULL;
   head->num=array[0];
   head->next=NULL;
   ptr = head;                    /* ��ptrָ������ʼ */
   for ( i = 1; i < len; i++ )    /* ������������·  */
   {
       ptr1 = ( llink ) malloc(sizeof(node));
       if ( !ptr1 )
          return NULL;
       ptr1->num = array[i];      /* �����������      */
       ptr1->next = NULL;         /* �趨ָ���ֵ      */
       ptr->next = ptr1;          /* ���ӽ��          */
       ptr = ptr->next;           /* ָ����һ���      */
   }
   return head;
}
/*�D�D�D�D�D�D�D�D�D�D�D�D����Ľ�����D�D�D�D�D�D�D�D�D�D�D*/
llink insertnode(llink head,int i,int value)
{
   
   /* ���ptr���ͷ�ڵ����ǲ����һ����� */
   if (i==1){
	   llink mnew;                      /* �½��ָ�����    */
	   mnew = ( llink ) malloc(sizeof(node));  /* �����½�� */
	   if ( !mnew )
		  return NULL;
	   mnew->num = value;              /* �����������      */
	   mnew->next =head;             /* �趨ָ���ֵ      */
	   head=mnew;
   }else{
	   llink ptr;
	   llink mnew;
	   int j;
	   ptr=head;
	   j=1;
	   while(ptr&&j<i-1) {ptr=ptr->next; ++j;}
	   if(!ptr||j>i-1) return NULL;
	   mnew = ( llink ) malloc(sizeof(node));  /* �����½�� */
	   if ( !mnew )
		  return NULL;
	   mnew->num = value;              /* �����������      */
	   mnew->next = ptr->next;        /* �½��ָ����һ��� */
       ptr->next = mnew;               /* ���ptrָ���½�� */
   }
   return head;
}
/*�D�D�D�D�D�D�D�D�D�D�D�D����Ľ��ɾ���D�D�D�D�D�D�D�D�D�D�D��*/
llink deletenode(llink head, int i)
{
	llink deleteptr;
	if(i==1){
		deleteptr=head;
		head=head->next;
		free(deleteptr);
	}else{
		llink previous;
		llink deleteptr;
		int j;
		previous = head;
		j=1;
	    while(previous&&j<i-1){previous=previous->next; ++j;}
	    if(!previous||j>i-1) return NULL;
	    deleteptr = previous->next;
        previous->next = previous->next->next;    /* ɾ�����      */
		free(deleteptr);                          /* �ͷŽ���ڴ�   */
	}
   return head;
}
/*�D�D�D�D�D�D�D�D�D�D�D�D�D������D�D�D�D�D�D�D�D�D�D�D*/
void main()
{
   int llist1[6] = { 1, 2, 3, 4, 5, 6 };   /*��������   */
   llink head;                          /* ָ������ʼ      */
   head = createllist(llist1,6);       /* ��������         */
   if ( !head )
   {
      printf("�ڴ����ʧ��! \n");
      exit(1);
   }
   printf("ԭ��������: ");
   printllist(head);               /* ���ԭ������      */
   head = insertnode(head,2,0); /* �����½��      */
   if ( !head )
   {
      printf("�ڴ����ʧ��! \n");
      exit(1);
   }
   /* ɾ�����ڽ�� */
   head = deletenode(head,4);
   printf("��������: ");
   printllist(head);              /*    ������    */
}
