#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
  vector<string> dic;
  vector< vector<char> > sd;
  string s;
  int count = 0;
  while(true){
    cin >> s;
    if(s == "XXXXXX")break;
    dic.push_back(s);
    vector<char> sc;
    for(int i = 0; i < s.size(); i++)sc.push_back(s[i]);
    sort(sc.begin(), sc.end());
    sd.push_back(sc);
  }

  while(true){
    cin >> s;
    if(s == "XXXXXX")break;
    vector<char> sc;
    for(int i = 0; i < s.size(); i++)sc.push_back(s[i]);
    sort(sc.begin(), sc.end());
    vector<string> ans;
    for(int i = 0; i < dic.size(); i++){
      if(dic[i].size() != s.size())continue;
      bool f = true;
      for(int j = 0; j < s.size(); j++){
        if(sc[j] != sd[i][j]){
          f = false;
          break;
        }
      }
      if(f)ans.push_back(dic[i]);
    }
    if(ans.size() > 0){
      sort(ans.begin(), ans.end());
      for(int i = 0; i < ans.size(); i++)cout << ans[i] << endl;
    }else{
      cout << "NOT A VALID WORD" << endl;
    }
    cout << "******" << endl;
  }

  return 0;
}
