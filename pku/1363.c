u[1001],n,k,b,p,f,i,c;
char s[4096];
main(){
  for(;scanf("%d\n",&n),n;){
    for(;gets(s),s[0]-'0';){
      memset(u,0,sizeof(u));
      for(c=b=0,p=-1,f=1;f;c++){
        for(k=0;s[c]!=' '&&s[c]!='\0';c++)k=k*10+s[c]-'0';
        if(s[c]=='\0')break;
        u[k]=1;
        if(p<k){
          for(i=k-1;i>=0;i--){if(!u[i]){b=i;break;}}
        }else{
          if(k!=b)f=0;
          for(i=k-1;i>=0;i--){if(!u[i]){b=i;break;}}
        }
        p=k;
      }
      printf(f?"Yes\n":"No\n");
    }
    puts("");
  }
}
