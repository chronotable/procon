#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(){
  int n;
  for(;;){
    cin >> n;
    if(!n)break;
    vector<string> dic;
    for(int i = 0; i < n; i++){
      string s;
      cin >> s;
      dic.push_back(s);
    }
    string t;
    cin >> t;
    int f[26] = {0};
    int wc = 0;
    for(int i = 0; i < t.size(); i++){
      if(t[i] == '_')wc++;
      else f[t[i] - 'A']++;
    }
    //cout << "wc = " << wc << endl;
    int ans = 0;
    for(int i = 0; i < n; i++){
      int g[26] = {0};
      int over = 0;
      for(int j = 0; j < dic[i].size(); j++){
        g[dic[i][j] - 'A']++;
      }
      for(int j = 0; j < 26;j++){
        if(g[j] > f[j])over += g[j] - f[j];
      }
      //cout << "over = " << over << endl;
      if(over <= wc)ans++;
    }
    cout << ans << endl;
  }

  return 0;
}
