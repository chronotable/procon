#include <iostream>

using namespace std;

int main(){
  int n,m,c;
  for(;;){
    cin >> n >> m >> c;
    if(n+m+c==0)break;
    int ans = 0;
    for(int i = m; i - 8 >= 0; i--){
      int start = n - 8 - ((m-i) % 2 == 0 ? 1-c : c);
      if(start < 0)continue;
      ans += 1 + start / 2;
    }
    cout << ans << endl;
  }
}