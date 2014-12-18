#include <iostream>
#include <vector>

using namespace std;

int main() {
  int n;
  while(cin >> n) {
    int m = 0;
    vector < vector<int> > t(n, vector <int> (n));
    cin >> t[0][0];
    int a;
    for(int i = 1; i < n; i++) {
      for(int j = 0; j <= i; j++) {
        cin >> a;
        if(j - 1 >= 0 && j <= i - 1) {
          t[i][j] = (a + t[i - 1][j - 1] > a + t[i - 1][j]) ?
            a + t[i - 1][j - 1] : a + t[i - 1][j];
        }else if(j - 1 >= 0) {
          t[i][j] = a + t[i - 1][j - 1];
        }else {
          t[i][j] = a + t[i - 1][j];
        }
      }
    }
    for(int j = 0; j < n; j++) {
      if(t[n - 1][j] > m) m = t[n - 1][j];
    }
    cout << m << endl;
  }
  return 0;
}