#include<stdio.h>
#include<stdlib.h>

typedef struct linklist {
	int num; //������
	struct linklist *next; //ָ����
}node;
typedef node *llink; //�ض���ָ������

llink creatllist(int *arry, int len) {
	llink head;
	llink ptr, ptr1;
	int i;
	head = (llink)malloc(sizeof(node));
	if (!head)
		return NULL;
	ptr = head; //��ptrָ������ʼ
	for (i = 0; i < len; i++) {
		ptr1 = (llink)malloc(sizeof(node));
		if (!ptr1)
			return NULL;
		ptr1->num = arry[i]; //�����������
		ptr1->next = NULL; //�趨ָ���ֵ
		ptr->next = ptr1; //���ӽ��
		ptr = ptr->next; //ָ����һ���
	}
	return head;
}

/*llink insertnode(llink head, llink ptr, int value) {
	llink newzhi;
	newzhi = (llink)malloc(sizeof(node));
	if (!newzhi)
		return NULL;
	newzhi->num = value;
	newzhi->next = NULL;
	newzhi->next = ptr->next;        
	ptr->next = newzhi;            
	return head;
}
llink Delete(llink head,llink ptr) {
	llink previous;
	previous = head;
	while (previous->next != ptr) // �ҽ��ptrǰһ��� 
		previous = previous->next;
	previous->next = ptr->next;    // ɾ���м���
	free(ptr);                     // �ͷŽ���ڴ�
	return head;
}*/

int Insert(llink head, int i, int e){//���� 
 	llink t,p; 	
	int j=1; 	
	t=head; 
	if(i<1){
		printf("�������,����ԭ����");
		return 0;
	} 	
	if(i==1){ //����λ���ڱ�ͷ  	
		p=(llink)malloc(sizeof(node)); 		
		p->num=e; 		
		p->next=t->next; 		
		head->next=p; 		
		//printf("����ɹ�\n"); 		
		return 0;	 
	} 	
	while(j<i-1&&head) { 			
		t=t->next; 			
		j++; 			
		if(t==NULL) { 				
			printf("������󣬷���ԭ����"); 				
			return 0; 			
		} 	
	} 	
	//���ڷǱ�ͷ 	
	t=t->next; 	
	p=(llink)malloc(sizeof(node)); 	
	p->num=e; 	
	p->next=t->next; 	
	t->next=p; 	
	//printf("����ɹ�\n");
}

int Delete(llink head, int i) {
	llink p, t;
	int j = 0;
	p = head;
	if (i < 1) {
		printf("ɾ��ʧ�ܣ�����ԭ����");
		return 0;
	}
	while (j < i - 1 && head) {
		p = p->next;
		j++;
		if (p == NULL) {
			printf("ɾ��ʧ�ܣ�����ԭ����");
			return 0;
		}
	}
	t = p->next;
	p->next = t->next;//ɾ���ɹ�
	free(t);
}



void outputlist(llink head) {
	llink ptr;
	ptr = head->next; //ָ����������ʼ
	while (ptr!= NULL) //�������ѭ��
	{
		printf("%d ", ptr->num); // ���������� 
		ptr = ptr->next; //ָ����һ��� 
	}
	printf("\n");               

}

int main(void) {
	int list[10];
	printf("������10������:\n");
	for (int i = 0; i < 10; i++) {
		scanf("%d", &list[i]);
	}
	llink head; //ָ������ʼ
	head = creatllist(list, 10);
	if (!head) {
		printf("�ڴ����ʧ�ܣ�\n");
		exit(1);
	}
	printf("ԭ��������");
	outputlist(head);
	printf("��������������ڵ��߸�λ���ϲ���99��");
	Insert(head,7,99); //�ڶ���������ʾ������ڼ���������룬�����������ǲ����ֵ
	outputlist(head);
	Delete(head, 6);//ͨ���޸ĵڶ�������ɾ��ͷ�ڵ��i����
	printf("��������:(ɾ����������) ");
	outputlist(head);
	/*head = insertnode(head, head->next->next, 8);
	if (!head)
	{
		printf("�ڴ����ʧ��! \n");
		exit(1);
	}
	printf("�����������");
	outputlist(head);
	head = Delete(head, head->next->next->next);
	printf("��������: ");
	outputlist(head);*/

}