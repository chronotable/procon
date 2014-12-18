char f[100][100];
u[100][100],n,m,a,i,j,g[]={1,1,0,-1,-1,-1,0,1},h[]={0,1,1,1,0,-1,-1,-1};
t(y,x){
  int c,d,k;
  u[y][x]=1;
  for(k=0;k<8;k++){
    d=x+g[k],c=y+h[k];
    if(c>=0&&c<n&&d>=0&&d<m&&f[c][d]=='W'&&!u[c][d])t(c,d);
  }
}
main(){
  scanf("%d%d",&n,&m);
  for(i=0;i<n;i++)scanf("%s",f[i]);
  for(i=0;i<n;i++){
    for(j=0;j<m;j++){
      if(f[i][j]=='W'&&!u[i][j])t(i,j),a++;
    }
  }
  printf("%d",a);
}
