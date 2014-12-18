#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
  int t;
  cin >> t;
  for(;t;t--){
    int n,m;
    cin >> n >> m;
    vector<int> sp;
    queue<int> q;
    for(int i = 0; i < n; i++){
      int task;
      cin >> task;
      sp.push_back(task);
      q.push(task + 10 * i);
    }
    sort(sp.begin(), sp.end());
    int ans = 0;
    for(int i = n-1; i >= 0; i--){
      for(;;){
        int task = q.front();
        q.pop();
        //printf("(%d, %d) ", task % 10, sp[i]);
        if(task % 10 == sp[i]){
          ans++;
          int ind = task / 10;
          if(ind == m){
            m = -1;
          }
          break;
        }else{
          q.push(task);
        }
      }
      if(m < 0)break;
    }
    cout << ans << endl;
  }

  return 0;
}
