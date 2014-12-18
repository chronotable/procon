#include <iostream>
using namespace std;

int main() {
  int n,r;
  int p,c;
  while(cin >> n >> r,n+r) {
    int card[n];
    for(int i = 0;i < n;i++) {
      card[i] = n - i;
    }
    while(r > 0) {
      cin >> p >> c;
      int a[p - 1];
      //int b[c];
      for(int i = 0;i < p - 1;i++) a[i] = card[i];
      for(int i = p - 1;i < p - 1 + c;i++) card[i - p + 1] = card[i];
      for(int i = c;i < c + p - 1;i++) card[i] = a[i - c];
      r--;
    }
    cout << card[0] << endl;
  }

  return 0;
}