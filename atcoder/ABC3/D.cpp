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

#define M (1<<10)
#define MOD (1000000007ll)

int R, C, X, Y, D, L;
ll comb[M][M];
ll memo[40][40];

ll calc(int h, int w){
  if(h <= 0 || w <= 0)
    return 0;
  if(memo[h][w] >= 0)
    return memo[h][w];
  ll ret = comb[w*h][D+L] * comb[D+L][D] % MOD;
  for(int i = 1; i <= h; i++)
    for(int j = 1; j <= w; j++)
      if(i < h || j < w)
        ret -= calc(i, j) * (h-i+1) % MOD * (w-j+1) % MOD;
  return memo[h][w] = (ret % MOD + MOD) % MOD;
}

int main(){

  memset(comb, 0, sizeof(comb));
  comb[0][0] = 1;
  for(int i = 1; i < M; i++){
    comb[i][0] = 1;
    for(int j = 1; j <= i; j++)
      comb[i][j] = (comb[i-1][j-1] + comb[i-1][j])%MOD;
  }

  cin >> R >> C >> X >> Y >> D >> L;
  memset(memo, -1, sizeof(memo));
  ll ans = calc(Y, X);
  ans = ans * (R - X + 1) % MOD * (C - Y + 1) % MOD;
  cout << ans << endl;

  return 0;
}
