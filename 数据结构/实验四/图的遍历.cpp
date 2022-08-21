#include<stdio.h>
#include <iostream>
#define MVNum 100//��󶥵���
#define MAXQSIZE 100//�����г���
using namespace std;					
bool visited[MVNum];//���ʱ�־���飬���ֵΪ"false" 

typedef int VertexType;//�������� 
typedef struct{
	VertexType vexs[MVNum];
	int arcs[MVNum][MVNum];//�ڽӾ����� 
    int vexnum,arcnum;//ͼ�ĵ�ǰ�����ͱ��� 	               		
}Graph;

typedef struct{  //���еĶ��� 
	int *base;  //��ʼ���Ķ�̬����洢�ռ�
	int front; //ͷָ�룬�����в��գ�ָ���ͷԪ��
	int rear; //βָ�룬�����в��գ�ָ���βԪ�ص���һ��λ��
}sqQueue;
void InitQueue(sqQueue &Q){//����һ���ն���Q
	Q.base = new int[MAXQSIZE];
	if(!Q.base)     
		exit(1);//�洢����ʧ��
	Q.front = Q.rear = 0;
}
void EnQueue(sqQueue &Q,int e){//����Ԫ��eΪQ���µĶ�βԪ��
	if((Q.rear+1)%MAXQSIZE==Q.front)
		return;//��β��ѭ�������ϼ�1����ͷָ�룬�������� 
	Q.base[Q.rear]=e;//��Ԫ�ز����β 
	Q.rear=(Q.rear+1)%MAXQSIZE;//��βָ���1 
}
bool QueueEmpty(sqQueue Q){//�ж��Ƿ�Ϊ�ն�	
	if(Q.rear == Q.front)
		return true;
	return false;
}
void DeQueue(sqQueue &Q, int &u){//��ͷԪ�س���
	//ɾ����ͷԪ�أ���u������ֵ	 
	u=Q.base[Q.front];
	Q.front=(Q.front+1)%MAXQSIZE;
} 
 								
int LocateVex(Graph G,VertexType v){
	//ȷ����v��G�е�λ��
	for(int i=0; i<G.vexnum;++i)
		if(G.vexs[i]==v)
			return i;
		return -1;
}
int CreateUDN(Graph &G){//�����ڽӾ����ʾ��������������G
	int i,j,k;
	printf("�������ܶ��������ܱ������Կո����:");
	scanf("%d %d",&G.vexnum,&G.arcnum);	
	printf("�����ı��\n");	
	for(i=0;i<G.vexnum;++i){
		printf("�������%d����ı��:",i+1);
		scanf("%d",&G.vexs[i]);//������������Ϣ
	}
			
	for(i=0;i<G.vexnum;++i)//��ʼ���ڽӾ��󣬱ߵ�Ȩֵ����Ϊ0 
		for(j=0;j<G.vexnum;++j)   
			G.arcs[i][j]=0;  
	printf("����������Ķ��㣬��1 2\n");
		
	for(k=0;k<G.arcnum;++k){//�����ڽӾ��� 
		VertexType v1,v2;
		printf("�������%d���������Ķ���:",k+1);
		scanf("%d %d",&v1,&v2);	//����һ���������Ķ���
		i=LocateVex(G,v1);  
		j=LocateVex(G,v2);//ȷ��v1��v2��G�е�λ�ã�������������±� 
		G.arcs[j][i]=G.arcs[i][j]=1;//��<v1, v2>�ĶԳƱ�<v2, v1>
	}	
}
							
void DFS(Graph G, int v){//����������ر���        		 
	int w;
	cout<<G.vexs[v]<<"  ";  visited[v]=true;//���ʵ�v�����㣬���÷��ʱ�־������Ӧ����ֵΪtrue 
	for(w=0;w<G.vexnum;w++)   //���μ���ڽӾ���v���ڵ���  
		if((G.arcs[v][w]!=0)&&(!visited[w]))  DFS(G, w); 
	//G.arcs[v][w]!=0��ʾw��v���ڽӵ㣬���wδ���ʣ���ݹ����DFS 
}

int FirstAdjVex(Graph G,int v){
	//����v�ĵ�һ���ڽӵ�
	int i;
	for(i=0;i<G.vexnum;++i){
		if(G.arcs[v][i]==1&&visited[i]==false)//������û�б����ʹ��� 
			return i;
	}
	return -1;//���û�б����ڣ���ʧ�� 
}
int NextAdjVex(Graph G,int v,int w){
	//����v�����w����һ���ڽӵ�
	int i;
	for(i=w;i<G.vexnum;++i){
		if(G.arcs[v][i]==1&&visited[i]==false)
			return i;
	}
	return -1;
}

void BFS (Graph G,int v){//���������������   
	sqQueue Q;
	int u,w;
    cout << G.vexs[v] << "  "; visited[v] = true;//���ʵ�v�����㣬���÷��ʱ�־������Ӧ����ֵΪtrue 
    InitQueue(Q);              					//��������Q��ʼ�����ÿ�         
    EnQueue(Q,v);            	               //v���� 
    while(!QueueEmpty(Q)){                    //���зǿ� 
		DeQueue(Q, u);       				 //��ͷԪ�س��Ӳ���Ϊu
		for(w=FirstAdjVex(G,u); w>=0; w=NextAdjVex(G,u,w)){
			//���μ��u�������ڽӵ�w ��FirstAdjVex(G, u)��ʾu�ĵ�һ���ڽӵ� 
			//NextAdjVex(G, u, w)��ʾu�����w����һ���ڽӵ㣬w��0��ʾ�����ڽӵ� 
			if(!visited[w]){	           		//wΪu����δ���ʵ��ڽӶ��� 
				cout<<G.vexs[w]<<"  "; visited[w] = true;	//����w�����÷��ʱ�־������Ӧ����ֵΪtrue 
				EnQueue(Q, w); //w����
			}
		}
    } 
}

int main(){
	Graph G;
	VertexType c;
	int i,j,tp;
	printf("************�ڽӾ����ʾ����ͼ�ı���************\n\n" );
	CreateUDN(G);
	printf("����ͼG������ɣ��ڽӾ����ʾ���£�\n");
	for (i=0;i<G.vexnum;i++){
      for (j=0;j<G.vexnum;j++)
         printf(" %d ",G.arcs[i][j]);//����������� 
      printf("\n");
   }
	printf("�������������ͼG����ʼ����:");	
	scanf("%d",&c);
	 
	for(i=0;i<G.vexnum;++i){
		if(c==G.vexs[i])
			break;//����i 
	}
	while(i>=G.vexnum){
		printf("�õ㲻���ڣ����������룡\n");
		printf("�����������ͨͼ����ʼ���ţ�") ;
		scanf("%d",&c);
		for(i=0;i<G.vexnum;++i){
			if(c==G.vexs[i])
				break;//����i 
		}
	}
	tp=i;
	printf("�������������������ͼG�����\n");
	DFS(G,i);
	printf("\n�������������������ͼG���:\n");
	for(i=0;i<G.vexnum;++i)
		visited[i]=false;
	BFS(G,tp);
}



