q,n,i,j;
main(){
  for(i=10;i>0;i--){
    j=getchar();
    if(j=='?')q=i;
    else if(j=='X')n+=10;
    else n+=i*(j-'0');
  }
  for(i=0;i<10;i++){
    if((n+q*i)%11==0)break;
  }
  if(i==10)if(q!=1||(n+10)%11!=0)i++;
  if(i<10)putchar(i+'0');
  else if(i==10)putchar('X');
  else printf("-1");
}
