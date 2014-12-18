f,v,t[101][101],dp[101][101],i,j,m;
main(){
  scanf("%d%d",&f,&v);
  for(i=0;i<f;i++)for(j=0;j<v;j++)scanf("%d",&t[i][j]),dp[i][j]=-9999;
  m=tra(-1,-1);
  printf("%d",m);
}
int tra(int x,int y){
  int a,b,c=-9999;
  x++;y++;
  if(x==f){
    return 0;
  }
  if(dp[x][y]!=-9999)return dp[x][y];
  for(a=y;a<v-(f-x)+1;a++){
    b=t[x][a] + tra(x,a);
    if(b>c)c=b;
  }
  dp[x][y]=c;
  return c;
}
