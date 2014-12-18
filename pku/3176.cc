#include <stdio.h>
#include <iostream>

using namespace std;

int max(int a, int b){
  return a > b ? a : b;
}

int main(int argc, char* argv[]){
  int n;
  cin >> n;
  int pins[351][351];
  for(int i = 1; i <= n; i++){
    for(int j = 0; j < i; j++)cin >> pins[i][j];
  }
  int dp[351][351];
  for(int i = 0; i <= 350;i++)for(int j = 0; j <= 350; j++)dp[i][j] = 0;
  dp[1][0] = pins[1][0];
  for(int i = 2; i <= n; i++){
    dp[i][0] = dp[i-1][0] + pins[i][0];
    for(int j = 1; j < i; j++)dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + pins[i][j];
    //for(int j = 0; j < i; j++)cout << dp[i][j] << " ";
    //cout << endl;
  }
  int ans = 0;
  for(int i = 0; i < n; i++)ans = max(ans, dp[n][i]);
  cout << ans << endl;

  return 0;
}
