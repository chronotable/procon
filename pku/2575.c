n,s[3000],u[3000],f,i,j;
main(){
  for(;~scanf("%d",&n);memset(u,0,sizeof(u))){
    for(f=i=0;i<n;i++)scanf("%d",s+i);
    for(i=1;i<n;i++){
      j=abs(s[i]-s[i-1]);
      if(j&&j<n&&!u[j])u[j]=1;
      else f=1;
    }
    printf(f?"Not jolly\n":"Jolly\n");
  }
}
