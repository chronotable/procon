g[50001],d[50001],n,m,s,t;
main(c){
  for(;scanf("%d%d",&n,&m),n+m;printf("Case %d: %d\n",c++,n)){
    for(s=1;s<=n;s++)d[s]=s,g[s]=1;
    for(;m>0;m--){
      scanf("%d%d",&s,&t);
      for(;s-d[s];s=d[s]);
      for(;t-d[t];t=d[t]);
      if(s-t){
        n--;
        if(g[s]>g[t])g[s]+=g[t],d[t]=d[s];
        else g[t]+=g[s],d[s]=d[t];
      }
    }
  }
}