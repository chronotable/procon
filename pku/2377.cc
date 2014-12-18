#include <iostream>
#include <stdio.h>

using namespace std;

int main(){

  int n,m;
  int cost[1001][1001];

  scanf("%d%d",&n,&m);
  for(int i = 0; i < 1001;i++)
    for(int j = 0; j < 1001;j++)cost[i][j] = 0;

  for(int i = 0; i < m; i++){
    int a,b,c;
    scanf("%d%d%d",&a,&b,&c);
    if(cost[a][b] < c)cost[a][b] = cost[b][a] = c;
  }
  int ans = 0;
  for(int o = 1; o < n; o++){
    int mx = -1;
    int ind = -1;
    for(int i = 2; i <= n; i++){
      if(cost[1][i] > 0 && cost[1][i] > mx){
        mx = cost[1][i];
        ind = i;
      }
    }
    if(mx < 0){
      ans = -1;
      break;
    }
    ans += mx;
    for(int i = 2; i <= n; i++){
      if(cost[1][i] < 0)continue;
      cost[1][i] = (cost[1][i] > cost[ind][i]) ? cost[1][i] : cost[ind][i];
    }
    cost[1][ind] = -1;
  }
  printf("%d\n",ans);

  return 0;
}
