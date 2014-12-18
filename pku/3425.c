n,u[1000001],s,q,a,x;
main(){
  for(scanf("%d",&n);n;n--){
    scanf("%d%d%d",&q,&a,&x);
    if(a){
      if(x)s+=u[q]*10+40;
      else s+=u[q]*10+20;
      u[q]++;
    }else{
      s+=10;
    }
  }
  printf("%d",s);
}
