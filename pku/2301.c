x,s,d;
main(){
  for(scanf("%d",&x);~scanf("%d%d",&s,&d);){
    if((s+d)%2){
      printf("impossible\n");
    }else{
      x=(s+d)/2;
      if(x-d>=0){
        printf("%d %d\n",x,x-d);
      }else{
        printf("impossible\n");
      }
    }
  }
}