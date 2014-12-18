#include <iostream>
#include <map>
#include <stdio.h>
#include <stdlib.h>

#define M (512)

using namespace std;

string c2s(char* buf){
  string ret = "";
  for(;*buf; buf++)ret += *buf;
  return ret;
}


int main(){
  map<string, string> lst;
  char buf[M];
  int n,m;

  cin.getline(buf, M);
  n = atoi(buf);

  for(int i = 0; i < n; i++){
    cin.getline(buf, M);
    string name = c2s(buf);
    cin.getline(buf, M);
    string party = c2s(buf);
    lst.insert(map<string, string>::value_type(name, party));
  }

  map<string, string>::iterator it;
  map<string, int>::iterator iu;
  map<string, int> vote;
  cin.getline(buf, M);
  m = atoi(buf);
  for(int i = 0; i < m; i++){
    cin.getline(buf, M);
    string name = c2s(buf);
    it = lst.find(name);
    if(it != lst.end()){
      iu = vote.find(it->first);
      if(iu == vote.end()){
        vote.insert(map<string, int>::value_type(it->first, 1));
      }else{
        vote[it->first]++;
      }
    }
  }

  iu = vote.begin();
  int mx = 0;
  string ans = "tie";
  for(;iu != vote.end(); iu++){
    if(iu->second > mx){
      mx = iu->second;
      ans = iu->first;
    }else if(iu->second == mx){
      ans = "tie";
    }
  }

  if(ans != "tie"){
    it = lst.find(ans);
    if(it != lst.end())ans = it->second;
  }

  cout << ans << endl;

  return 0;
}
