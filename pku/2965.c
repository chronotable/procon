r[4],c[4],n,i,j,k,t;
char s[4][9];
main(){
  for(i=0;i<4;i++){
    gets(s[i]);
    for(j=0;j<4;j++){
      if(s[i][j]=='-')r[i]++,c[j]++;
    }
  }
  for(i=0;i<4;i++){
    for(j=0;j<4;j++){
      k=r[i]+c[j];
      if(s[i][j]=='-')k--;
      if(k%2==0)n++;
    }
  }
  printf("%d\n",n);
  for(i=0;i<4;i++){
    for(j=0;j<4;j++){
      k=r[i]+c[j];
      if(s[i][j]=='-')k--;
      if(k%2==0)printf("%d %d\n",i+1,j+1);
    }
  }
}
