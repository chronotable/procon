char bf[11][11],af[11][11],p[11][11];
n,g,i,j,k,b,c,d,x[8]={1,1,0,-1,-1,-1,0,1},y[8]={0,1,1,1,0,-1,-1,-1};
main(){
  scanf("%d",&n);
  for(i=0;i<n;i++)scanf("%s",bf+i);
  for(i=0;i<n;i++)scanf("%s",af+i);
  for(i=0;i<n;i++)for(j=0;j<n;j++)if(af[i][j]=='x'&&bf[i][j]=='*')g=1;
  for(i=0;i<n;i++){
    for(j=0;j<n;j++){
      if(g&&bf[i][j]=='*'){putchar('*');}
      else if(af[i][j]=='.'){putchar('.');}
      else if(af[i][j]=='x'){
        for(b=k=0;k<8;k++){
          c=i+y[k],d=j+x[k];
          if(c>=0&&c<n&&d>=0&&d<n&&bf[c][d]=='*')b++;
        }
        putchar(b+'0');
      }
    }
    puts("");
  }
}
