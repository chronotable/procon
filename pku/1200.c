long long h[5000000],s;
char t[1000000];
a,n,c,l,i,j;
void f(long long n){
  if(h[n%5000000]==0){
    h[n%5000000]=s;a++;
  }else{
    if(h[n%5000000]!=s)f(n*999983%5000000);
  }
}
main(){
  scanf("%d%d%s",&n,&c,t);
  l=strlen(t);
  for(i=0;i<=l-n;i++){
    s=0;
    for(j=i;j<i+n;j++){
      s=s*26+t[j]-'a';
    }
    f(s);
  }
  printf("%d\n",a);
}
