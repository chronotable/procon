#include <iostream>
#include <cmath>
using namespace std;

int main() {
  int N;
  int w,h;
  while(cin >> N) {
    for(int i = 0; i < N; i++) {
      cin >> h >> w;
      printf("Scenario #%d:\n", i + 1);
      if((h * w) % 2 == 1) {
        printf("%.2f\n", (double)(h * w - 1 + sqrt(2.0)));
      }else {
        printf("%.2f\n", (double)w * h);
      }
      printf("\n");
    }
  }
}

