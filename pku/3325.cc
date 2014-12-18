#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
  for(;;){
    int n;
    cin >> n;
    if(n==0)break;
    vector<int> s;
    for(int i = 0; i < n; i++){
      int v;
      cin >> v;
      s.push_back(v);
    }
    sort(s.begin(), s.end());
    int sum = 0;
    for(int i = 1; i < n-1; i++)sum += s[i];
    cout << sum/(n-2) << endl;
  }
}
