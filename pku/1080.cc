#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <iostream>
#include <algorithm>
#include <cmath>
#include <map>

using namespace std;

int main(){
  int T;
  scanf("%d", &T);
  map<char, int> c2i;
  c2i['A'] = 0; c2i['C'] = 1; c2i['G'] = 2; c2i['T'] = 3;
  int tbl[5][5] = {
    5, -1, -2, -1, -3,
    -1, 5, -3, -2, -4,
    -2, -3, 5, -2, -2,
    -1, -2, -2, 5, -1,
    -3, -4, -2, -1, 0
  };
  char a[110], b[110];
  int dp[110][110];
  const int INF = 1<<30;
  for(;T>0;T--){
    int al, bl;
    scanf("%d%s%d%s", &al, a+1, &bl, b+1);
    for(int i = 0; i <= al; i++)for(int j = 0; j <= bl; j++)dp[i][j] = -INF;
    dp[0][0] = 0;
    for(int j = 1; j <= bl; j++)dp[0][j] = dp[0][j-1] + tbl[c2i[b[j]]][4];
    for(int i = 1; i <= al; i++)dp[i][0] = dp[i-1][0] + tbl[c2i[a[i]]][4];
    for(int i = 1; i <= al; i++)
      for(int j = 1; j <= bl; j++){
        dp[i][j] = dp[i-1][j-1] + tbl[c2i[a[i]]][c2i[b[j]]];
        dp[i][j] = max(dp[i][j], dp[i-1][j] + tbl[c2i[a[i]]][4]);
        dp[i][j] = max(dp[i][j], dp[i][j-1] + tbl[c2i[b[j]]][4]);
      }
    printf("%d\n", dp[al][bl]);
  }

  return 0;
}
