#include<stdio.h>
int Search_Bin(int a[],int key,int low,int high){//�ݹ�ʵ���۰����
	int mid;
	if(low>high)
		return -1;
	else{
		mid=(low+high)/2;
		if(a[mid]==key)
			return mid;
		if(a[mid]<key)
			return Search_Bin(a,key,mid+1,high);
		else
			return Search_Bin(a,key,low,mid-1);}
}

int search_bin(int a[],int key,int low,int high){
	int mid;
	while(low<=high){
		mid=(low+high)/2;
		if(key==a[mid]) {return mid;}
		else if(key<a[mid]) {high=mid-1;}
		else {low=mid+1;}	
	}
	return -1;
}


int main(){
	int addr;
	int a[9]={0,2,4,8,14,25,36,47,68};
	printf("˳����е�Ԫ�����£�\n");
	for(int i=0;i<9;i++)
		printf("%d ",a[i]);
	printf("\n");
	
	addr=Search_Bin(a,25,0,8);//�ݹ���25
	if(addr!=-1)
		printf("25���±���%d\n",addr);
	else
		printf("û��key\n");
				
	addr=Search_Bin(a,22,0,8);//�ݹ���22
	if(addr!=-1)
		printf("22���±���%d\n",addr);
	else
		printf("û��key\n");
			
	addr=search_bin(a,26,0,8);//�ǵݹ���26 
	if(addr!=-1)
		printf("26���±���%d\n",addr);
	else
		printf("û��key\n");
		
	addr=search_bin(a,4,0,8);//�ǵݹ���4
	if(addr!=-1)
		printf("4���±���%d\n",addr);
	else
		printf("û��key\n");
	return 0;
}

