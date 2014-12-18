#include <stdio.h>
using namespace std;

int main(){
  int o;
  for(scanf("%d",&o); o; o--){
    int n,sum=0,v;
    scanf("%d",&n);
    sum -= n-1;
    for(;n;n--){
      scanf("%d",&v);
      sum+=v;
    }
    printf("%d\n",sum);
  }
  return 0;
}