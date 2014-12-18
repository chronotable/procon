#include<iostream>

using namespace std;

int main() {
  int n,k;
  int t,g;
  while(cin >> n >> k) {
    t = 0;
    g = 0;
    while(n > 0) {
      t += n;
      if(g > 0) {
        n += g;
        g = 0;
      }
      g += n % k;
      n /= k;
    }
    cout << t << endl;
  }
  return 0;
}