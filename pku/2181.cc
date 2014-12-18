#include <iostream>
#include <stdio.h>
using namespace std;

int main(){
  int m,v;
  int p = 0, n = 0,np,nn;
  scanf("%d",&m);
  for(int i = 0; i < m; i++){
    scanf("%d", &v);
    np = p; nn = n;
    if(p < n + v)np = n+v;
    if(n < p - v)nn = p - v;
    p = np; n = nn;
  }
  int ans = 0;
  if(ans < p)ans = p;
  if(ans < n)ans = n;
  printf("%d\n", ans);
}
