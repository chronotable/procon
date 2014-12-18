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

#define M 370

vector< pair<int, int> > sc[M];
int dp[M][M];

int solve(){
  for(int i = 0; i < M; i++)for(int j = 0; j < M; j++)dp[i][j]=-1;
  dp[1][1] = 0;
  for(int day = 1; day <= 365; day++)
    for(int end = day; end <= 366; end++)
      if(dp[day][end] >= 0){
        int tm = day+1;
        dp[tm][max(end, tm)] = max(dp[tm][max(end, tm)], dp[day][end]);
        if(day == end){
          for(int i = 0; i < sc[day].size(); i++){
            int next = sc[day][i].first+1;
            dp[tm][next] = max(dp[tm][next], dp[day][end] + sc[day][i].second);
          }
          for(int i = 0; i < sc[day].size(); i++)
            for(int j = i+1; j < sc[day].size(); j++){
              int sum = sc[day][i].second + sc[day][j].second;
              int mn = min(sc[day][i].first, sc[day][j].first)+1;
              int mx = max(sc[day][i].first, sc[day][j].first)+1;
              dp[mn][mx] = max(dp[mn][mx], dp[day][end]+sum);
            }
        }else{
          for(int i = 0; i < sc[day].size(); i++){
            int mn = min(sc[day][i].first+1, end);
            int mx = max(sc[day][i].first+1, end);
            dp[mn][mx] = max(dp[mn][mx], dp[day][end] + sc[day][i].second);
          }
        }
      }
  int ans = 0;
  for(int i = 1; i < M; i++)for(int j = 1; j < M; j++)ans = max(ans, dp[i][j]);
  return ans;
}

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  for(;;){
    int n;
    scanf("%d", &n);
    if(n==0)break;
    for(int i = 0; i < M; i++)sc[i].clear();
    for(int i = 0; i < n; i++){
      int s, e, w;
      scanf("%d%d%d", &s, &e, &w);
      sc[s].push_back(make_pair(e, w));
    }
    printf("%d\n", solve());
  }

  return 0;
}
