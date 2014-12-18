n,v,t,i;
double a,b;
main(){
  for(;scanf("%d",&n),n;){
    a=1000000.0;
    for(i=0;i<n;i++){
      scanf("%d%d",&v,&t);
      if(t<0)continue;
      b=4500.0*3600/(v*1000)+t;
      
      if(a>b)a=b;
    }
    printf("%.0lf\n",ceil(a));
  }
}
