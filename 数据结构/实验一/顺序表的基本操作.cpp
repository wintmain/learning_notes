#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 100//˳�����ܴﵽ����󳤶�

typedef int Elemtype;
typedef int Status;

typedef struct list{
	Elemtype *elem;
	int len;
	int listsize;
}List;

void list_init(List *L){
	L->elem = (Elemtype *)malloc(MAXSIZE * sizeof(Elemtype));//���ٿռ�
	if (L->elem == NULL){//�жϿռ��Ƿ񿪱ٳɹ�
		printf("�������ʧ���˳�\n");
		exit(0);
	}
	L->len = 0;	//��ʼ��������Ч����Ϊ0
	L->listsize = MAXSIZE;	//��ʼ�����鳤��ΪMAXSIZE
}

Status list_insert(List *L, int i, Elemtype data){
	Elemtype *base, *insert, *p;
	if ((i<1) || (i>L->len + 1) || (L == NULL)){//iֵ���Ϸ�
		printf("λ���������\n");
		return 0;
	}
	if (L->len > L->listsize){//�����ﵽԤ������ռ�ʱ����Ҫ��̬����
		base = (Elemtype *)realloc(L->elem, (L->listsize + MAXSIZE) * sizeof(Elemtype));
		L->elem = base;
		L->listsize += MAXSIZE;
	}
	insert = &(L->elem[i - 1]);//Ŀ��ָ��ָ��Ҫ�����Ŀ���ַ
							   //ָ�����һ��Ԫ�صĵ�ַ
	for (p = L->elem + L->len - 1; p >= insert; p--){
		*(p + 1) = *p;//����λ�ü�֮���Ԫ�غ���
	}
	*insert = data;//dataֵ���ڵ�i��λ��
	++L->len;//����1
	return 1;
}

Status list_delete(List *L, int i){
	Elemtype *aim, *p;
	if ((i<1) || (i>L->len)){//iֵ���Ϸ�
		printf("λ���������\n");
		return 0;
	}
	aim = &(L->elem[i-1]);//Ŀ��ָ��ָ��Ҫɾ����Ŀ���ַ
	p = (L->elem + L->len - 1); //ָ�����һ��Ԫ�صĵ�ַ
	for (aim = aim + 1; aim <= p; ++aim){ 
		*(aim - 1) = *aim;//��ɾ��Ԫ��֮���Ԫ��ǰ��
	}
	--L->len;//����1
	return 1;
}

Status list_search(List L, Elemtype e) {
	int m;
	for (m = 0; m < L.len; m++) {
		if (L.elem[m] == e)
			break;
	}
	printf("%d\n", m + 1);
	if (m + 1 > L.len) printf("���ڳ���˳����������λ�ã���δ�ҵ�%d\n",e);
	return 0;
}

void show_list(List *L){
	int i;
	for (i = 0; i<L->len; i++){
		printf("elem[%d]=%d\n", i+1 , L->elem[i]);
	}
	printf("\n");
}
int main(){
	int i;
	list L;
	list_init(&L);
	for (i = 0; i<10; i++){
		list_insert(&L, i + 1, i + 1);
	}
	printf("����ǰ��˳���\n");
	show_list(&L);

	printf("������˳���  ��5λ�ò���99\n");
	list_insert(&L, 5, 99);
	show_list(&L);

	printf("ɾ�����˳���  ��4λ��ɾ��\n");
	list_delete(&L, 4);
	show_list(&L);

	printf("����˳�����ֵΪ9��λ��:");
	list_search(L, 9);
	printf("����˳�����ֵΪ18��λ��:");
	list_search(L, 18);
	return 0;
}
