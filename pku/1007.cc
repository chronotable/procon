#include <iostream>
#include <vector>
using namespace std;

int main() {
  int n,m;
  int i,j,k;
  while(cin >> n >> m) {
    vector<string> dnas(m);
    for(i = 0; i < m; i++) {
      cin >> dnas[i];
    }
    vector< pair<int, string> > cost(m);
    for(i = 0; i < m; i++) {
      int c = 0;
      for(j = 0; j < n - 1; j++) {
        for(k = j + 1; k < n; k++) {
          if(dnas[i].at(j) > dnas[i].at(k)) c++;
        }
      }
      cost[i] = make_pair(c, dnas[i]);
    }

    sort(cost.begin(), cost.end());
    for(i = 0; i < m; i++) {
      cout << cost[i].second << endl;
    }
  }

  return 0;
}