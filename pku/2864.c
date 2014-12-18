#include <stdio.h>
int main(){int i,j,n,d,v,a[101];for(;scanf("%d%d",&n,&d),n;printf("%s\n",n-i?"yes":"no")){for(i=0;i<101;i++)a[i]=0;for(i=0;i<d;i++)for(j=0;j<n;j++)scanf("%d",&v),a[j]+=v;for(i=0;i<n;i++)if(a[i]==d)break;}return 0;}
