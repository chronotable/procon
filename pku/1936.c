#include<string.h>
int main(){
  char s[100005],t[100005];
  int i,j;
  int slen,tlen;
  for(;~scanf("%s %s",s,t);){
    slen = strlen(s);
    tlen = strlen(t);
    for(i=j=0;j<tlen;j++)if(s[i]==t[j])if(++i==slen)break;
    printf("%s\n",i==slen?"Yes":"No");
  }
}