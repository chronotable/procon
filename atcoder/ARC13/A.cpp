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

int a[3];
int b[3];

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  for(int i = 0; i < 3; i++)scanf("%d", a+i);
  for(int j = 0; j < 3; j++)scanf("%d", b+j);
  sort(a, a+3); sort(b, b+3);
  int ans = 0;
  do{
    ans = max(ans, (a[0]/b[0]) * (a[1]/b[1]) * (a[2]/b[2]));
  }while(next_permutation(b, b+3));
  //int ans = (a[0]/b[0]) * (a[1]/b[1]) * (a[2]/b[2]);
  printf("%d\n", ans);

  return 0;
}
