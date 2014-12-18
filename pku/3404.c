#include <stdio.h>

int cmp(const void* a, const void* b){
  return (*(int*)a) - (*(int*)b);
}

int main(){
  int a[50];
  int n,i,s;
  scanf("%d",&n);
  for(i=0;i<n;i++)scanf("%d",a+i);
  qsort(a,n,sizeof(int),cmp);
  for(s=0;;){
    if(n==1){s+=a[0];break;}
    if(n==2){s+=a[1];break;}
    if(n==3){s+=a[0]+a[1]+a[2];break;}
    if(2*a[1]<a[0]+a[n-2])s+=a[1]+a[0]+a[n-1]+a[1];
    else s+=a[n-1]+a[0]+a[n-2]+a[0];
    n-=2;
  }
  printf("%d\n",s);
}

