s[100001],t[2][100001],m[2][100001],n,i,j,a,o;
main(){
  for(scanf("%d",&o);o;o--){
    scanf("%d",&n);
    for(i=0;i<n;i++)scanf("%d",s+i);
    t[0][0]=m[0][0]=s[0];
    for(i=1;i<n;i++){
      t[0][i]=t[0][i-1]>0?t[0][i-1]+s[i]:s[i];
      m[0][i]=m[0][i-1]>t[0][i]?m[0][i-1]:t[0][i];
    }
    t[1][n-1]=m[1][n-1]=s[n-1];
    for(i=n-2;i>=0;i--){
      t[1][i]=t[1][i+1]>0?t[1][i+1]+s[i]:s[i];
      m[1][i]=m[1][i+1]>t[1][i]?m[1][i+1]:t[1][i];
    }
    for(a=-(1<<30),i=0;i<n-1;i++){
      j=m[0][i]+m[1][i+1];
      if(j>a)a=j;
    }
    printf("%d\n",a);
  }
}