#include <iostream>
#include <vector>
#include <algorithm>
#include <stdio.h>

using namespace std;

int main(){
  for(;;){
    vector<int> points;
    int p;
    int sum = 0;
    for(int i = 0; i < 6; i++){
      cin >> p;
      sum += p;
      points.push_back(p);
    }
    sort(points.begin(), points.end());
    if(sum == 0)break;
    sum -= points[0] + points[5];
    if(sum % 4 == 0)printf("%d\n", sum / 4);
    else{
      int mod = sum % 4;
      printf("%d.", sum / 4);
      while(mod > 0){
	mod *= 10;
	printf("%d", mod / 4);
	mod = mod % 4;
      }
      printf("\n");
    }
  }

  return 0;
}