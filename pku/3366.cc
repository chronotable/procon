#include <iostream>
#include <stdio.h>
#include <map>

using namespace std;

int main(){

  int L,N;
  cin >> L >> N;
  map<string, string> dic;
  for(int i = 0; i < L; i++){
    string p,q;
    cin >> p >> q;
    dic.insert(pair<string, string>(p, q));
  }
  for(int i = 0; i < N; i++){
    string s,ans="hoge";
    cin >> s;
    if(dic.find(s) != dic.end()){
      ans = dic.find(s)->second;
    }else{
      if(s[s.size()-1] == 'y'){
	char b = s[s.size()-2];
	if(b != 'a' && b != 'i' && b != 'u' && b != 'e' && b != 'o'){
	  ans = s.substr(0, s.size() - 1) + "ies";
	}else{
	  ans = s + "s";
	}
      }else{
	char tail = s[s.size()-1];
	if(tail == 'o' || tail == 's' || tail == 'x' ||
	   s.substr(s.size() -2) == "ch" ||
	   s.substr(s.size() -2) == "sh"){
	  ans = s + "es";
	}else{
	  ans = s + "s";
	}
      }
    }
    cout << ans << endl;
  }

  return 0;
}
