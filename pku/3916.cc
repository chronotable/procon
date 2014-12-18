#include <stdio.h>
#include <stdlib.h>

#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
#include <map>
#include <set>

using namespace std;

int main(int argc, char* argv[]){
  for(;;){
    int n;
    scanf("%d", &n);
    if(!n)break;
    int prev = -1;
    for(int i = 0; i < n; i++){
      int v;
      scanf("%d", &v);
      if(prev==v)continue;
      prev = v;
      printf("%d ", v);
    }
    printf("$\n");
  }

  return 0;
}
