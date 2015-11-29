#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <iostream>
#include <cmath>
#include <algorithm>

#include <string>
#include <vector>
#include <deque>
#include <queue>
#include <set>
#include <map>

using namespace std;

typedef long long ll;

int n;
int a[1<<20];
int b[1<<20];

int main(){
  scanf("%d", &n);
  for(int i = 0; i < n; i++)scanf("%d", a+i);
  for(int j = 0; j < n; j++)scanf("%d", b+j);
  ll ans = 1ll * b[0] * n;
  ll maxb = b[0];
  ll suma = 0;
  ll need = 0;
  for(int i = 0; i < n; i++){
    if(a[i] + suma < 0){
      ll c = -(a[i] + suma);
      if(maxb == 0)
        break;
      ll day = (c + maxb - 1) / maxb;
      if(day + need > n)
        break;
      suma += maxb * day;
      need += day;
    }
    suma += a[i];
    need++;
    if(need > n)
      break;
    if(i < n - 1 && maxb < b[i+1])
      maxb = b[i+1];
    ans = max(ans, suma + 1ll * (n - need) * maxb);
  }
  cout << ans << endl;

  return 0;
}
