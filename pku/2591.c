int n,ans[10000009],f,s,x,y,m;
main(){
  ans[f=s=1]=1;
  for(n=2;n<10000001;n++){
    x=ans[f]*2+1;
    y=ans[s]*3+1;
    if(x<y)ans[n]=x,f++;
    else if(x>y)ans[n]=y,s++;
    else ans[n]=x,f++,s++;
  }
  for(;~scanf("%d",&m);){
    printf("%d\n",ans[m]);
  }
}