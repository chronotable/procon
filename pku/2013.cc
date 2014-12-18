#include <iostream>
#include <vector>
#include <deque>
#include <string>
using namespace std;

int main(){
  for(int o = 1;;o++){
    int n;
    cin >> n;
    if(n==0)break;
    vector<string> p(n);
    for(int i = 0; i < n; i++){
      string s;
      cin >> s;
      if(i % 2 == 0)p[i/2] = s;
      else p[n-1-i/2] = s;
    }
    cout << "SET " << o << endl;
    vector<string>::iterator it = p.begin();
    for(;it != p.end(); it++){
      cout << *it << endl;
    }
  }
}
