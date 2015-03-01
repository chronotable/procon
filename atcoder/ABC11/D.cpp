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

#define M (1010)

double comb[M][M];
double fp[M];

int main(){
  int n, d, x, y;
  scanf("%d%d%d%d", &n, &d, &x, &y);
  x = abs(x); y = abs(y);
  if(x % d != 0 || y % d != 0){
    printf("0.0\n"); return 0;
  }
  x /= d; y /= d;
  /*
  if(x+y > n){
    printf("0.0\n"); return 0;
  }
  */

  comb[0][0] = 1;
  double cur = 1.0 / 2.0;
  for (int i = 1; i < M; i++) {
    comb[i][0] = cur;
    for (int j = 1; j < M; j++) {
      comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) / 2.0;
    }
    cur /= 2.0;
  }
  /*
  fp[0] = 1;
  for(int i = 1; i < M; i++)
    fp[i] = fp[i-1] / 2.0;
  */
  double ans = 0;
  for(int i = 0; i <= n; i++){
    int j = n-i;
    if(i < y || j < x)
      continue;
    if(((i + y) & 1) || ((j + x) & 1))
      continue;
    int ny = (i + y) >> 1;
    int nx = (j + x) >> 1;
    //ans += comb[n][i] * fp[n] * comb[i][ny] * fp[i] * comb[j][nx] * fp[j];
    ans += comb[n][i] * comb[i][ny] * comb[j][nx];
  }
  printf("%.15f\n", ans);

  return 0;
}
