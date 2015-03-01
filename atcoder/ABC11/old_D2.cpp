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

#define B (50)

const int dx[] = {1, 0, -1, 0};
const int dy[] = {0, 1, 0, -1};
double dp[2][B*2][B*2];
int w = B*2, h = B*2;

inline bool out(int y, int x){
  return x < 0 || x >= w || y < 0 || y >= h;
}

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
  if(out(y, x)){
    printf("0.0\n"); return 0;
  }
  int cur = 0;
  dp[cur][B][B] = 1;
  for(int o = 0; o < n; o++){
    int next = 1-cur;
    for(int i = 0; i < h; i++)for(int j = 0; j < w; j++)dp[next][i][j] = 0;
    for(int i = 0; i < h; i++)
      for(int j = 0; j < w; j++)
        for(int a = 0; a < 4; a++){
          int ny = i + dy[a];
          int nx = j + dx[a];
          if(out(ny, nx))
            continue;
          dp[next][ny][nx] += dp[cur][i][j] / 4;
        }
    cur = next;
  }
  printf("%.10f\n", dp[cur][y][x]);

  return 0;
}
