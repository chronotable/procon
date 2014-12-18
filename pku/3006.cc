#include <iostream>
#include <math.h>

using namespace std;

bool isprim(int n) {
  if(n < 2) return false;
  if(n == 2) return true;
  if(n % 2 == 0) return false;
  int max = (int)sqrt((double)n) + 1;
  for(int i = 3; i < max;i += 2) {
    if(n % i == 0) return false;
  }
  return true;
}

int main() {
  int a,d,n;
  while(cin >> a >> d >> n,a + d + n) {
    int c = 0;
    while(true) {
      if(isprim(a)) c++;
      if(c == n) break;
      a += d;
    }
    cout << a << endl;
  }
  return 0;
}