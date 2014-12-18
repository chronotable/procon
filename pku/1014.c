a,s,f[2][60001],m[7],n,i,j,k;
main(c){
  for(;1;c++){
    for(a=s=0,i=1;i<7;s+=m[i]*i++)scanf("%d",m+i);
    if(!s)break;
    memset(f,0,sizeof(f));
    if(s%2){
      s/=2;
    }else{
      s/=2;
      for(i=0;i<=m[1];i++)f[0][i]=1;
      for(i=2;i<7;i++){
        for(j=0;j<i;j++){
          for(n=m[i],k=j;k<=s;k+=i){
            if(f[i%2][k]){
              f[(i+1)%2][k]=1;
              n=0;
            }else if(n<m[i]){
              f[(i+1)%2][k]=1;n++;
            }
          }
        }
      }
    }
    printf("Collection #%d:\nCan%s be divided.\n\n",c,f[1][s]?"":"'t");
  }
}
