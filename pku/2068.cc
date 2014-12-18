#include <iostream>
using namespace std;

int main() {
  int n;
  int s;
  int* m;
  int i,j,k,a;
  int** relation;
  while(cin >> n,n) {
    cin >> s;
    m = (int*)calloc(2 * n, sizeof(int));
    for(i = 0; i < 2 * n; i++) cin >> m[i];
    relation = (int**)calloc(s, sizeof(int*));
    for(i = 0; i < s; i++) relation[i] = (int*)calloc(n * 2, sizeof(int));
    for(i = 0; i < s; i++) {
      for(j = 0; j < 2 * n; j++) {
        if(!relation[i][j]) {
          k = (j - 1 + 2 * n) % (2 * n);
          for(a = 1; a <= m[k] && i + a < s; a++) {
            relation[i + a][k] = 1;
          }
        }
      }
    }
    cout << relation[s - 1][0] << endl;
    free(m);
    for(i = 0; i < s; i++) free(relation[i]);
    free(relation);
  }

  return 0;
}
