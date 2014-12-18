#include <iostream>
#include <cmath>
using namespace std;

int mypow(int x, int y) {
  if(y == 0) return 1;
  if(y % 2) {
    return x * mypow(x * x, y / 2);
  }else {
    return mypow(x * x, y / 2);
  }
}

int main() {
  int b,n;
  int a;
  int on;

  while(cin >> b >> n, b + n) {
    a = 1;
    on = n;
    while(abs(b - mypow(a,n)) > abs(b - mypow(a + 1, n))) a++;
    cout << a << endl;
  }

  return 0;
}