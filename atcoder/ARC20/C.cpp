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
int a[10010];
int L[10010];
int B;

ll modpow(ll a, ll n, ll mod){
  ll ret = 1;
  ll mul = a;
  for(; n; n >>= 1){
    if(n&1)
      ret = (ret * mul) % mod;
    mul = (mul * mul) % mod;
  }
  return ret;
}

ll inv(ll a, ll p){
  return (a == 1 ? 1 : (1 - p*inv(p%a, a)) / a + p);
}

int main(){
  scanf("%d", &n);
  for(int i = 0; i < n; i++)
    scanf("%d%d", a+i, L+i);
  scanf("%d", &B);
  ll cur = 0;
  for(int i = 0; i < n; i++){
    ll base = 1;
    while(base <= a[i])
      base *= 10;
    ll ln = modpow(base, L[i], B);
    cur = cur * ln;
    cur %= B;
    cur += 1ll * a[i] * (ln==0?B-1:ln-1) % B * inv(base-1, B) % B;
    cur %= B;
  }
  printf("%lld\n", cur);

  return 0;
}
