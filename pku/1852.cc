#include <stdio.h>

int max(int a, int b){
  return a>b?a:b;
}

int min(int a, int b){
  return a<b?a:b;
}

using namespace std;

int main(){
  int o,n,a,e,l,p;
  for(scanf("%d",&o);o;o--){
    scanf("%d%d",&n,&a);
    e=l=-1;
    for(int i = 0; i < a; i++){
      scanf("%d",&p);
      if(e<min(n-p,p))e=min(n-p,p);
      if(l<max(n-p,p))l=max(n-p,p);
    }
    printf("%d %d\n",e,l);
  }
  return 0;
}
