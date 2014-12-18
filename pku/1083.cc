#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>
#include <string.h>

using namespace std;

int main(int argc, char* argv[]){
  int t, n, s, e, ans;
  int u[201];
  cin >> t;
  for(;t > 0;t--){
    memset(u, 0, sizeof(u));
    cin >> n;
    ans = 0;
    for(int i = 0; i < n; i++){
      cin >> s >> e;
      if(s > e)
        swap(s, e);
      for(int j = (s-1) / 2; j <= (e-1)/2; j++)u[j]++;
    }
    ans = 0;
    for(int i = 0; i <= 200; i++)ans = max(ans, u[i]);
    cout << (ans*10) << endl;
  }

  return 0;
}
