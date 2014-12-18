#include <iostream>
#include <cmath>
using namespace std;
int main() {
  int n,m,i,j;
  while(cin >> n >> m, n + m != -2) {
    int lim = (int)sqrt((double)m * 2);
    while(lim * (lim - 1) / 2 < m && m != 0) lim++;
    int top = m - ((lim - 1) * (lim - 2) / 2) + 1;
    for(i = 0; i < n - lim; i++) cout << i + 1 << " ";
    if(m != 0) cout << top + (n - lim) << " ";
    for(j = n; j > n - lim; j--) {
      if(j == top + (n - lim)) continue;
      cout << j << " ";
    }
    cout << endl;
  }
  return 0;
}