char s[999],*p;
a,b;
main(){
  for(;gets(s),s[0]-'0';a=0){
    for(p=s;*p!='\0';p++)a+=*p-'0';
    for(b=0;a>9;a=b,b=0)for(;a>0;a/=10)b+=a%10;
    printf("%d\n",a);
  }
}
