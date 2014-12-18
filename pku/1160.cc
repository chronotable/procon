#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

int cost[301][301];
int dp[31][301];
int x[301];

int main(){
  int v,p;
  scanf("%d%d",&v,&p);
  for(int i = 1; i <= v; i++)scanf("%d",x+i);

  for(int i = 1; i <= v; i++){
    for(int j = i; j <= v; j++){
      cost[i][j] = 0;
      int mid = (i+j) / 2;
      for(int k = i; k <= mid; k++)cost[i][j] += x[mid] - x[k];
      for(int k = mid + 1; k <= j; k++)cost[i][j] += x[k] - x[mid];
    }
  }

  int M = 100000000;

  for(int i = 0; i<= p; i++)
    for(int j = 0; j <= v; j++)dp[i][j] = M;
  dp[0][0] = 0;
  for(int i = 0; i <= p; i++){
    for(int j = 0; j <= v; j++){
      if(dp[i][j] < M){
        for(int k = j + 1; k <= v; k++){
          if(dp[i+1][k] > dp[i][j] + cost[j+1][k])
            dp[i+1][k] = dp[i][j] + cost[j+1][k];
        }
      }
    }
  }

  printf("%d\n", dp[p][v]);

  return 0;
}
