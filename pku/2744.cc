#include <iostream>
using namespace std;

int main() {
  int i,j;
  int n, r;
  double b, v, e, f;
  int* a;
  double* time;
  double* pit;

  while(cin >> n,n) {
    a = (int*)calloc(n + 1, sizeof(int));
    for(i = 1; i <= n; i++) cin >> a[i];
    cin >> b;
    cin >> r >> v >> e >> f;
    time = (double*)calloc(a[n] + 1,sizeof(double));
    for(i = 1; i <= r; i++) time[i] = time[i - 1] + 1.0 / (v - f * (r - (i - 1)));
    for(; i <= a[n]; i++)  time[i] = time[i - 1] + 1.0 / (v - e * (i - 1 - r));
    pit = (double*)calloc(n + 1, sizeof(double));

    for(i = 1; i <= n; i++) {
      pit[i] = time[a[i]];
      for(j = 0; j < i; j++) {
        pit[i] = min(pit[j] + b + time[a[i] - a[j]], pit[i]);
      }
    }

    printf("%.4f\n", pit[n]);

    free(a);
    free(time);
    free(pit);
  }

  return 0;
}
