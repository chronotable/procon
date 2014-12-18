#include <iostream>
using namespace std;
#define MAXN 300

int main() {
  int t[MAXN + 2];
  int w[MAXN + 1];
  int total;
  int n;
  int i;

  t[1] = 1;
  for(i = 2; i < MAXN + 2; i++) t[i] = t[i - 1] + i;
  w[1] = t[2];
  for(i = 2; i < MAXN + 1; i++) w[i] = w[i - 1] + i * t[i + 1];
  cin >> total;
  for(i = 0; i < total; i++) {
    cin >> n;
    printf("%d %d %d\n", i + 1, n, w[n]);
  }

  return 0;
}