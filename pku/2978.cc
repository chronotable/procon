#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int ans;
int s[200];
int m,k;

/*
void tra(int prev, vector<int> id, int cur, int sum){
  if(cur == k-1){
    for(int i = prev+1; i < m; i++)if(s[i] != id[cur])sum++;
    if(ans > sum)ans = sum;
    return;
  }
  int count = 0;
  for(int i = 0; i < tn[id[cur]]; i++){
    if(tbl[id[cur]][i] > prev){
      tra(tbl[id[cur]][i], id, cur+1,
	  sum + tbl[id[cur]][i] - prev - count - 1);
      count++;
    }
  }
}
*/

#define MIN(a, b) a < b ? a : b

int main(){
  while(1){
    int cut[6][101];
    cin >> m >> k;
    if(m+k==0)break;
    vector<int> id;
    for(int i = 1; i <= k; i++){
      id.push_back(i);
      cut[i][0] = 0;
    }
    for(int i = 1; i <= m; i++){
      cin >> s[i];
      //tbl[s[i]][tn[s[i]]++] = i;
      for(int j = 1; j <= k; j++){
	if(s[i] != j)cut[j][i] = cut[j][i-1]+1;
	else cut[j][i] = cut[j][i-1];
      }
    }
    ans = 10000;
    do{
      int dp[6][101];
      for(int i = 1; i <= m; i++)dp[0][i] = cut[id[0]][i];
      for(int i = 1; i < k; i++){
	for(int j = 1; j <= m; j++){
	  dp[i][j] = 1000000;
	  for(int p = 1; p <= j; p++){
	    dp[i][j] = MIN(dp[i][j],
			   dp[i-1][p] + cut[id[i]][j] - cut[id[i]][p]);
	  }
	}
      }
      ans = MIN(ans, dp[k-1][m]);
    }while(next_permutation(id.begin(), id.end()));
    cout << ans << endl;
  }

  return 0;
}
