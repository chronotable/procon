#include <iostream>
#include <string>
#include <stdio.h>

using namespace std;

int dsum(string s){
  int ret = 0;
  for(int i = 0; i < s.size(); i++){
    if(s[i] >= '0' && s[i] <= '9')
      ret += s[i] - '0';
    else
      ret += s[i] - 'a' + 10;
  }
  return ret;
}

string convert(int v, int base){
  string ret = "";
  while(v > 0){
    int mod = v % base;
    v /= base;
    if(mod < 10)
      ret = (char)(mod + '0') + ret;
    else
      ret = (char)(mod - 10 + 'a') + ret;
  }
  return ret;
}

int main(){
  for(int i = 2992; i < 10000; i++){
    int ans10 = dsum(convert(i, 10));
    int ans12 = dsum(convert(i, 12));
    int ans16 = dsum(convert(i, 16));
    if(ans10 == ans12 && ans12 == ans16)
      cout << i << endl;
  }

  return 0;
}
