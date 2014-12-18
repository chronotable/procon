#include <iostream>
using namespace std;

int main(){
  int n;
  string f,s;
  int fl, sl;
  cin >> n;
  for(;n--;){
    cin >> f >> s;
    while(f[0]=='0')f = f.substr(1);
    while(s[0]=='0')s = s.substr(1);
    fl = f.size();
    sl = s.size();
    int carry = 0;
    string ans("");
    int i;
    bool headput = false;
    for(i = 0; i < fl && i < sl; i++){
      int sum = f[i] - '0' + s[i] - '0' + carry;
      carry = 0;
      if(sum > 9){
        sum -= 10;
        carry = 1;
      }
      if(sum > 0)headput = true;
      if(headput)ans += (char)(sum + '0');
    }
    for(;i < fl; i++){
      int sum = f[i] - '0' + carry;
      carry = 0;
      if(sum > 9){
        sum -= 10;
        carry = 1;
      }
      if(sum > 0)headput = true;
      if(headput)ans += (char)(sum + '0');
    }
    for(;i < sl; i++){
      int sum = s[i] - '0' + carry;
      carry = 0;
      if(sum > 9){
        sum -= 10;
        carry = 1;
      }
      if(sum > 0)headput = true;
      if(headput)ans += (char)(sum + '0');
    }
    if(carry > 0) ans += '1';
    cout << ans << endl;
  }

  return 0;
}