#include <iostream>
using namespace std;

int main() {
  int n;
  int* a;
  int val;
  int i, j, k;
  while(cin >> n) {
    a = (int*)calloc(n, sizeof(int));
    cin >> a[0];
    for(i = 1; i < n; i++) {
      cin >> val;
      for(j = 0; j < i; j++) {
        if(val < a[j]) {
          for(k = i; k > j; k--) {
            a[k] = a[k - 1];
          }
          break;
        }
      }
      a[j] = val;
    }
    cout << a[n / 2] << endl;
  }

  return 0;
}
