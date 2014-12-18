#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(int argc, char* argv[]){
  int y;
  double bit,mx;
  double cur;
  int ans;
  
  for(;;){
    scanf("%d", &y);
    if(!y)break;
    bit = 2.0;
    while(y >= 1960){
      y-=10;
      bit *= 2.0;
    }
    //bit = 4.0 * pow(2.0, (y - 1960) / 10.0);
    //mx = pow(2.0, bit);
    cur = 0;
    for(ans = 1; ;ans++){
	cur += log(ans) / log(2.0);
	if(cur > bit)break;
    }
    printf("%d\n", ans-1);
  }

  return 0;
}
