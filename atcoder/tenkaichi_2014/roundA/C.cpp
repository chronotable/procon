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

int n, m;
char p[15][100010];

bool match(int a, int b){
  for(int i = 0; i < m; i++){
    if(p[a][i] != '*' && p[b][i] != '*' && p[a][i] != p[b][i])
      return false;
  }
  return true;
}

int g[15][15];
int c[1<<15];
int dp[1<<15];
#define INF (1<<20)

int main(){
  scanf("%d%d", &n, &m);
  for(int i = 0; i < n; i++)
    scanf("%s", p[i]);
  const int lim = 1<<n;
  memset(g, 0, sizeof(g));
  for(int i = 0; i < n; i++)
    for(int j = i+1; j < n; j++)
      if(match(i, j))
        g[i][j] = g[j][i] = 1;
  memset(c, 0, sizeof(c));
  for(int i = 1; i < lim; i++){
    vector<int> a;
    for(int j = 0; j < n; j++)if((i>>j)&1)a.push_back(j);
    int s = a.size();
    bool ok = true;
    for(int j = 0; j < s; j++)for(int k = j+1; k < s; k++)if(!g[a[j]][a[k]])ok = false;
    if(ok)
      c[i] = 1;
  }
  for(int i = 0; i < lim; i++)dp[i] = INF;
  dp[0] = 0;
  for(int i = 1; i < lim; i++){
    vector<int> a;
    for(int j = 0; j < n; j++)if((i>>j)&1)a.push_back(j);
    int s = a.size();
    int state = 1<<s;
    for(int j = 1; j < state; j++){
      int mask = 0;
      for(int k = 0; k < s; k++)if((j>>k)&1)mask |= 1<<a[k];
      if(c[mask])
        dp[i] = min(dp[i], dp[i^mask] + 1);
    }
  }
  printf("%d\n", dp[lim-1]);

  return 0;
}
