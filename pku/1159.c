char b[5002],s[5002];
short t[5001][5001];
n,i,j,k;
short max(short x,short y){return x>y?x:y;}
main(){
  scanf("%d%s",&n,s);
  memset(t,0,sizeof(t));
  for(i=0;i<n;i++)b[i]=s[n-i-1];
  b[i]='\0';
  for(i=1;i<=n;i++){
    for(j=1;j<=n;j++){
      if(s[i-1]-b[j-1])t[i][j]=max(t[i-1][j],t[i][j-1]);
      else t[i][j]=t[i-1][j-1]+1;
    }
  }
  printf("%d",n-t[n][n]);
}
