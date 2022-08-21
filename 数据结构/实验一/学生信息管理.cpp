#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct student {
	int num;
	int grade;
	char name[20];
	struct student *next;
}student;
student *head;
int length;

void creat() {
	student *p1, *p2;
	length = 0;
	int number = 0;
	p1 = (student *)malloc(sizeof(student));
	p1->num = -1;

	if (head == NULL)
		head = p1;
	printf("������ѧ��ѧ�š��������ɼ���\n");
	while (number <= 5) {
		p2= (student *)malloc(sizeof(student));
		scanf("%d %s %d", &p2->num, p2->name, &p2->grade);
		if (p2->num == 0) {
			printf("ѧ����Ϣ������ɣ�\n");
			break;
		}
		length++;
		p1->next = p2;
		p2->next = NULL;
		p1 = p1->next;
		number++;
	}

}

void show() {
	student *p = head->next;
	printf("����ѧ����Ϣ���£�\n");
	while (p != NULL) {
		printf("%d %s %d\n", p->num, p->name, p->grade);
		p = p->next;
	}

}

void numsearch() {
	int xuehao;
	student *p = head->next;
	printf("��������Ҫ���ҵ�ѧ����ѧ��\n");
	scanf("%d", &xuehao);
	while (p != NULL) {
		if (p->num == xuehao) {
			printf("��Ҫ��ѧ����Ϣ���£�\n");
			printf("%d %s %d\n", p->num, p->name, p->grade);
			return;
		}
		p = p->next;
	}
	if (p == NULL)
		printf("�Ҳ�����ѧ�ŵ�ѧ��\n");
	return;
}

void insert(){
	int num_, i;
	student *p, *q;
	p = head;
	printf("��������Ҫ����λ��: ");
	scanf("%d", &num_);
	if (num_>length){
		printf("�Ҳ���Ҫ�����λ��\n");
		return;
	}
	else{
		printf("��������Ҫ�����ѧ����ѧ�š��������ɼ���\n");
		q = (student *)malloc(sizeof(student));
		scanf("%d %s %d", &q->num, q->name, &q->grade);
		while (p != NULL){
			if (p->num == q->num){
            printf("��ѧ���Ѿ����ڣ��޷�������Ϣ��\n");
			return;
}
p = p->next;
}
p = head;
for (i = 0; i<num_; i++)
p = p->next;
q->next = p->next;
p->next = q;
length++;
printf("����ѧ����Ϣ�ɹ���\n");
return;}

}

void Delete(){
	int num_;
	student *p, *q;
	q = head, p = head->next;
	printf("������Ҫɾ����ѧ����ѧ��:\n");
	scanf("%d", &num_);
	while (p != NULL){
		if (p->num == num_){
			q->next = p->next;
			free(p);
			length--;
			printf("ɾ���ɹ���\n");
			return;
		}
		p = p->next;
		q = q->next;
	}
	if (p == NULL){
		printf("�Ҳ���Ҫɾ����ѧ�ţ�\n");
		return;
	}
}

void menu() {
	printf("***************************************************************\n");
	printf("| 1�� ���ѧ����Ϣ |\n");
	printf("| 2�� ��ʾѧ����Ϣ |\n");
	printf("| 3�� ����ĳ��ѧ����Ϣ |\n");
	printf("| 4�� ɾ��ָ��ѧ�ŵ�ѧ�� |\n");
	printf("| 5�� ָ����λ���ϲ���ѧ����Ϣ |\n");
	printf("****************************************************************\n");
}
int main(void) {
	int a;
	menu();
	while (1) {
		printf("��ѡ����Ҫ�Ĺ���:");
		scanf("%d", &a);
		switch (a){
		case 0:return 0;
		case 1:
			creat();
			menu();
			break;
		case 2:
			if (head)
			{
				show();
				menu();
			}
			else
			{
				printf("ѧ����ϢΪ�գ����Ƚ���ѧ����Ϣ��\n");
				menu();
			}
			break;
		case 3:
			if (head) {
				numsearch();
				menu();
			}
			else
			{
				printf("ѧ����ϢΪ�գ����Ƚ���ѧ����Ϣ��\n");
				menu();
			}
			break;
		case 4:
			if (head)
			{
				Delete();
				menu();

			}
			else
			{
				printf("ѧ����ϢΪ�գ����Ƚ���ѧ����Ϣ��\n");
				menu();
			}
		break;
		case 5:
			if (head)
			{
				insert();
				menu();
			}
			else
			{
				printf("ѧ����ϢΪ�գ����Ƚ���ѧ����Ϣ��\n");
				menu();
			}
			break;
		default:
			break;
		}
	}
	system("pause");
	return 0;
}