char a[1000000],b[1000000],c[1000000],s[4];
int n,i,j,u;
main(){
  scanf("%d\n",&n);
  for(i=0;i<n;i++){
    gets(s);
    a[i]=s[0];
    b[i]=s[2];
  }
  for(i=n-1;i>=0;i--)
    c[i]=u+a[i]-'0'+b[i],u=c[i]>'9'?1:0,c[i]-=c[i]>'9'?10:0;
  c[n]='\0';
  puts(c);
}
