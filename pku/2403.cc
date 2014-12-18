#include <iostream>
#include <map>

using namespace std;

int main(){
  int m, n;
  cin >> m >> n;
  map<string, int> dic;
  for(int i = 0; i < m; i++){
    string w;
    int p;
    cin >> w >> p;
    dic.insert(pair<string, int>(w,p));
  }

  for(int i = 0; i < n; i++){
    int ans = 0;
    string w;
    map<string, int>::iterator it;
    while(true){
      cin >> w;
      if(w == ".")break;
      it = dic.find(w);
      if(it != dic.end()){
        ans += it->second;
      }
    }
    cout << ans << endl;
  }

  return 0;
}
