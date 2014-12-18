#include<iostream>
using namespace std;

int main() {
  string* field;
  string** dp;
  string max;
  string  up;
  string left;
  int w,h;
  int i,j;
  while(true) {
    cin >> w >> h;
    if(w == 0 && h == 0) break;

    field = new string[h];
    for(i = 0; i < h; i++) {
      cin >> field[i];
    }
    dp =  new string*[h];
    for(i = 0; i < h; i++) {
      dp[i] = new string[w];
    }

    max = "0";
    for(i = 0; i < h; i++) {
      for(j = 0; j < w; j++) {
        if(j == 0) left = "0";
        else left =  dp[i][j - 1];
        if(i ==  0) up =  "0";
        else up =  dp[i - 1][j];
        if(field[i][j] >= 'A' && field[i][j] <= 'Z') {
          dp[i][j] = "0";
        }else {
          if(left.size() > up.size()) {
            if(left != "0") {
              dp[i][j] =  left + field[i][j];
            }else {
              dp[i][j] = field[i][j];
            }
          }else if(left.size() < up.size()){
            if(up != "0") {
              dp[i][j] =  up +  field[i][j];
            }else {
              dp[i][j] = field[i][j];
            }
          }else if(left == "0"&&up=="0"){
            dp[i][j] = field[i][j];
          }else {
            int k;
            for(k = 0; k < left.size(); k++) {
              if(left[k] > up[k]) {
                dp[i][j] = left + field[i][j];
                break;
              }else if(left[k] < up[k]){
                dp[i][j] = up + field[i][j];
                break;
              }
            }
            if (k==left.size()) dp[i][j]=up+field[i][j];

          }
          if(max.size() < dp[i][j].size()) {
            max = dp[i][j];
          }else if(max.size() == dp[i][j].size()) {
            for(int k = 0; k < max.size(); k++) {
              if(max[k] < dp[i][j][k]) {
                max = dp[i][j];
                break;
              }
            }
          }
        }
      }
    }
    cout << max << endl;
  }
  return 0;
}
