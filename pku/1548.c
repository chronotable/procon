f[26][26],dp[26][26],i,j;
int m(x,y){return x>y?x:y;}
main(){
  for(;;){
    memset(f,0,sizeof(f));
    for(;scanf("%d%d",&i,&j);){
      if(!i)break;
      if(i<0)return;
      f[i][j]=1;
    }
    memset(dp,0,sizeof(dp));
    for(i=24;i>0;i--){
      for(j=1;j<25;j++){
        if(f[i][j])dp[i][j]=dp[i+1][j-1]+1;
        else dp[i][j]=m(dp[i][j-1],dp[i+1][j]);
      }
    }
    printf("%d\n",dp[1][24]);
  }
}
