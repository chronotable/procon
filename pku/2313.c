m,n,a,b,c,s,t;main(i){
  for(scanf("%d%d",&m,&b),a=b;i<m;i++){
    scanf("%d",&c);
    t=b-c;
    n+=abs(t);
    if(s*t<0){
      if(abs(s)<abs(t)){
        n-=abs(s);
        b=a;
        t=b-c;
      }else{
        n-=abs(t);
        b=c;
        t=0;
      }
    }
    s=t;a=b;b=c;
  }
  printf("%d\n",n);
}
