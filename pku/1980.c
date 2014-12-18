#include <stdio.h>

int p,q,a,n,ans;

double eps = 1e-11,frac[12001];

void tra(double rest,int denom, int prod, int lim){
  int i;
  double d;
  if(lim<=0) {
    if(fabs(rest)<eps)ans++;
    return;
  }
  if(fabs(rest)<eps){ans++;return;}
  for(i=denom;i <= a/prod;i++){
    d=frac[i];
    if(d*lim-rest<-eps)break;
    if(rest-d<-eps)continue;
    tra(rest-d,i,prod*i,lim-1);
  }
}

main(){
  int g,i;
  double fval,t;
  for(i=1;i<=12000;i++)frac[i]=1.0/i;
  for(;scanf("%d%d%d%d",&p,&q,&a,&n),p+q+a+n;){
    ans=0;
    fval=(double)p/(double)q;
    for(i=1;i<=a;i++){
      t=frac[i];
      if(t*n-fval<-eps)break;
      if(fval-t<-eps)continue;
      tra(fval-t,i,i,n-1);
    }
    printf("%d\n",ans);
  }
}
