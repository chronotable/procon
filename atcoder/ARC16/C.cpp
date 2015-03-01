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

int N, M;
int C[10];
int cost[10];
int idol[10][20];
int p[10][20];
double dp[1<<12];

double calc(int mask){
  if(dp[mask] >= 0)
    return dp[mask];
  if(mask == (1<<N)-1)
    return 0;
  double ret = 1e50;
  for(int i = 0; i < M; i++){
    int prob = 0;
    double sum = 0;
    for(int j = 0; j < C[i]; j++){
      if(mask & (1<<idol[i][j])){
        prob += p[i][j];
      }else{
        sum += (calc(mask | (1<<idol[i][j])) + cost[i]) * p[i][j] / 100;
      }
    }
    if(prob == 100)
      continue;
    sum = (sum + cost[i] * prob / 100.0) / ((100-prob)/100.0);
    if(ret > sum)
      ret = sum;
  }
  return dp[mask] = ret;
}

int main(){
  scanf("%d%d", &N, &M);
  for(int i = 0; i < M; i++){
    scanf("%d%d", C+i, cost+i);
    for(int j = 0; j < C[i]; j++){
      scanf("%d%d", idol[i]+j, p[i]+j);
      idol[i][j]--;
    }
  }
  for(int i = 0; i < (1<<N); i++)
    dp[i] = -1;
  printf("%.9f\n", calc(0));

  return 0;
}
