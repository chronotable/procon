n,k,i;
main(){
  for(;scanf("%d",&n),n;){
    if(n%6==2||n%6==3){
      k=n/2;
      if(k%2){
        for(i=0;k+i<=n-1;i+=2)printf("%d ",k+i);
        for(i=1;i<=k-2;i+=2)printf("%d ",i);
        for(i=3;k+i<=n;i+=2)printf("%d ",k+i);
        for(i=2;i<=k+1;i+=2)printf("%d ",i);
        if(n%2)printf("%d",n);
        puts("");
      }else{
        for(i=0;k+i<=n;i+=2)printf("%d ",k+i);
        for(i=2;i<=k-2;i+=2)printf("%d ",i);
        for(i=3;k+i<=n-1;i+=2)printf("%d ",k+i);
        for(i=1;i<=k+1;i+=2)printf("%d ",i);
        if(n%2)printf("%d",n);
        puts("");
      }
    }else{
      for(i=2;i<=n;i+=2)printf("%d ",i);
      for(i=1;i<=n;i+=2)printf("%d ",i);
      puts("");
    }
  }
}
