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

int main(){
  int n, a;
  set<int> s;
  scanf("%d", &n);
  for(;n-->0;){
    scanf("%d", &a);
    while(a%2==0)
      a >>= 1;
    s.insert(a);
  }
  printf("%d\n", s.size());

  return 0;
}
