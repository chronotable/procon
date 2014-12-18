#include <iostream>
using namespace std;

int main(){
  int o,n,r,q,i,j,a,b,c;
  int s[50001];
  for(o=1;;o++){
    scanf("%d",&n);
    if(!n)break;
    for(i=1;i <= n;i++)s[i] = i;
    scanf("%d",&r);
    for(i=0; i<r;i++){
      scanf("%d%d",&a,&b);
      while(a<b){
        c = s[a];
        s[a] = s[b];
        s[b] = c;
        a++;b--;
      }
    }
    scanf("%d",&q);
    printf("Genome %d\n",o);
    for(i=0; i < q;i++){
      scanf("%d",&a);
      for(j=1;j <= n;j++)
        if(s[j]==a){
          printf("%d\n",j);
          break;
        }
    }
  }
}
