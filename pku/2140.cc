#include <iostream>
using namespace std;

int main() {
  int n;
  while(cin >> n) {
    int m;
    int num = 0;;
    for(m = 1; m <= n; m++) {
      if(m * (m + 1) / 2 > n) break;
      if(m % 2 == 1) {
        if(n % m == 0) num++;
      }else {
        if((n + (m / 2)) % m == 0) num++;
      }
    }
    cout << num << endl;
  }
}