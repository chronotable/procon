#include <stdio.h>
#include <math.h>

int main() {
  double sum = 0,a,b,c,d,x,y,r;
  int i,n;

  scanf("%d%lf",&n, &r);

  for(i = 0; i < n; i++) {
    scanf("%lf%lf", &a, &b);
    if(i == 0) {
      x = a; y = b;
    }else {
      sum += sqrt((c - a) * (c - a) + (d - b) * (d - b));
    }
    c = a; d = b;
  }
  sum += sqrt((x - a) * (x - a) + (y - b) * (y - b));
  printf("%.2f", sum + 2 * r * 3.1415);
}