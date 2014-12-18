#include <iostream>
#include <algorithm>
using namespace std;

int main(){
  int n,b;
  cin >> n >> b;
  int h[n];
  for(int i = 0; i < n;i++)cin >> h[i];
  int sum = 0;
  sort(h, h+n);
  for(int i = n-1; i>=0;i--){
    sum += h[i];
    if(sum >= b){
      cout << (n-i) << endl;
      break;
    }
  }

  return 0;
}
