dp[102][201],g[101],c[101],l,n,i,j,k,v;
main(){
  scanf("%d",&l);
  for(n=1;~scanf("%d%d",g+n,c+n);n++);
  g[n--]=l;
  for(i=0;i<=n+1;i++)for(j=0;j<=200;j++)dp[i][j]=1<<30;
  dp[0][100]=0;
  for(i=0;i<=n;i++){
    for(j=0;j<=200;j++){
      if(dp[i][j]==1<<30)continue;
      if(j<g[i+1]-g[i])continue;
      if(c[i+1]){
        for(k=j-(g[i+1]-g[i]);k<=200;k++){
          v=dp[i][j]+(k-(j-(g[i+1]-g[i])))*c[i+1];
          if(dp[i+1][k]>v)dp[i+1][k]=v;
        }
      }else{
        v=dp[i][j];
        if(dp[i+1][j-(g[i+1]-g[i])]>v)dp[i+1][j-(g[i+1]-g[i])]=v;
      }
    }
  }
  if(dp[n+1][100]!=1<<30)printf("%d",dp[n+1][100]);
  else printf("Impossible");
}
