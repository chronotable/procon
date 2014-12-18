h[5900],p2,p3,p5,p7,m1,m2,n,i;
char* suf[] = {"st","nd","rd"};
int min(x,y){return x<y?x:y;}
main(){
  for(p2=p3=p5=p7=h[1]=1,i=2;i<=5842;i++){
    m1=min(h[p2]*2,h[p3]*3);
    m2=min(h[p5]*5,h[p7]*7);
    m1=min(m1,m2);
    h[i]=m1;
    if(m1==h[p2]*2)p2++;
    if(m1==h[p3]*3)p3++;
    if(m1==h[p5]*5)p5++;
    if(m1==h[p7]*7)p7++;
  }
  for(;scanf("%d",&n),n;){
    printf("The %d",n);
    if(n%10<4&&n%10>0&&(n/10%10!=1)){
      printf("%s ",suf[n%10-1]);
    }else{
      printf("th ");
    }
    printf("humble number is %d.\n",h[n]);
  }
}
