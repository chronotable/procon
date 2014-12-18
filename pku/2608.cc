#include <iostream>
#include <stdio.h>

using namespace std;

int main(){

  int tbl[] = {0,1,2,3,0,1,2,0,0,2,2,4,5,5,0,1,2,6,2,3,0,1,0,2,0,2};

  string s;
  while(cin>>s){
    string ans = "";
    for(int i = 0; i < s.size(); i++){
      if(i==0 && tbl[s[i]-'A'])ans += (char)(tbl[s[i] - 'A'] + '0');
      else if(tbl[s[i-1]-'A'] != tbl[s[i]-'A'] && tbl[s[i]-'A'])
        ans += (char)(tbl[s[i] - 'A'] + '0');
    }
    cout << ans << endl;
  }

  return 0;
}
