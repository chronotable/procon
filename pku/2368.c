#include <stdio.h>
#include <math.h>
int main() {
  int n,nn,i,ans;
  scanf("%d",&n);
  if(n > 10) nn = (int)sqrt((double)n) + 1;
  else nn = n;
  for(i = 3; i < nn; i++) {
    if(n % i == 0) break;
  }
  ans = (i < nn) ? i - 1 : n - 1;
  if(ans == n - 1 && n % 2 == 0) ans = n / 2 - 1;
  if(n == 4) ans = 3;
  printf("%d", ans);
  return 0;
}