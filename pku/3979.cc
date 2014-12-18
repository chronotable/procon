#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <iostream>
#include <cmath>
#include <algorithm>

#include <string>
#include <vector>
#include <deque>
#include <queue>
#include <set>
#include <map>

using namespace std;

typedef long long ll;

char s[1024];

int gcd(int x, int y){
  int t;
  while(y != 0){
    t = x % y; x = y; y = t;
  }
  return x;
}

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  for(; ~scanf("%s", s);){
    char op = s[3];
    int a = s[0] - '0', b = s[2] - '0', c = s[4] - '0', d = s[6] - '0';
    int bunsi = a*d + (op=='+'?c*b:-c*b);
    int bunbo = b*d;
    if(bunsi == 0){
      printf("0\n");
      continue;
    }
    int g = gcd(abs(bunsi), bunbo);
    bunsi /= g; bunbo /= g;
    if(bunbo == 1){
      printf("%d\n", bunsi);
    }else{
      printf("%d/%d\n", bunsi, bunbo);
    }
  }

  return 0;
}
