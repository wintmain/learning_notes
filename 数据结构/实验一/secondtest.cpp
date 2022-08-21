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
   ptr = head->next;              /*  ָ����������ʼ   */
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
   ptr = head;                    /* ��ptrָ������ʼ */
   for ( i = 0; i < len; i++ )    /* ������������·  */
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
int insertnode(llink &head,llink ptr,int value)
{
   llink mnew;                      /* �½��ָ�����    */
   mnew = ( llink ) malloc(sizeof(node));  /* �����½�� */
   if ( !mnew )
      return 0;
   mnew->num = value;              /* �����������      */
   mnew->next = NULL;              /* �趨ָ���ֵ      */
   /* ���ptr���ͷ�ڵ����ǲ����һ����� */
   mnew->next = ptr->next;        /* �½��ָ����һ��� */
   ptr->next = mnew;               /* ���ptrָ���½�� */
   return 1;
}
/*�D�D�D�D�D�D�D�D�D�D�D�D����Ľ��ɾ���D�D�D�D�D�D�D�D�D�D�D��*/
llink deletenode(llink head,llink ptr)
{
   llink previous;
   previous = head;
   while ( previous->next != ptr ) /* �ҽ��ptrǰһ��� */
      previous = previous->next;
   previous->next = ptr->next;    /* ɾ���м���      */
   free(ptr);                     /* �ͷŽ���ڴ�   */
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
  
   if ( !insertnode(head,head,0) )
   {
      printf("�ڴ����ʧ��! \n");
      exit(1);
   }
   /* ɾ�����ڽ�� */
   head = deletenode(head,head->next->next->next);
   printf("��������: ");
   printllist(head);              /*    ������    */
}


