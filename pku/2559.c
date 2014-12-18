typedef struct r{
  double h,p;
}r;
r s[100009];
double a,b;
double c[100009];
t,n,i,j;
main(){
  for(;scanf("%d",&n),n;printf("%.0lf\n",a)){
    for(i=0;i<n;i++)scanf("%lf",c+i);
    c[n]=-1;
    for(a=t=i=0;i<=n;i++){
      if(!t){
        s[t].h=c[i];s[t++].p=i;
      }else{
        if(s[t-1].h<c[i]){
          s[t].h=c[i];s[t++].p=i;
        }else if(s[t-1].h>c[i]){
          j=i;
          for(;t&&s[t-1].h>=c[i];){
            b=s[t-1].h*(i-s[t-1].p);
            a=a<b?b:a;
            j=s[--t].p;
          }
          s[t].p=j;s[t++].h=c[i];
        }
      }
    }
  }
}
