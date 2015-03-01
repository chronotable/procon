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

#define B (1010)

const int dx[] = {1, 0, -1, 0};
const int dy[] = {0, 1, 0, -1};

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  int n, d, x, y;
  scanf("%d%d%d%d", &n, &d, &x, &y);
  if(x % d != 0 || y % d != 0){
    printf("0.0\n"); return 0;
  }
  x /= d; y /= d;
  x += B; y += B;
  map< pair<int, int>, double> dp;
  map< pair<int, int>, double>::iterator it;
  dp[make_pair(B, B)] = 1;
  for(int o = 0; o < n; o++){
    map< pair<int, int>, double> next;
    for(it = dp.begin(); it != dp.end(); it++){
      int cx = it->first.first;
      int cy = it->first.second;
      double p = it->second;
      if(p < 1e-9)continue;
      if(abs(cx - x) + abs(cy - y) > n-o)continue;
      for(int i = 0; i < 4; i++)
        next[make_pair(cx - dx[i], cy - dy[i])] += p/4;
    }
    dp = next;
  }
  printf("%.10f\n", dp[make_pair(x, y)]);

  return 0;
}
