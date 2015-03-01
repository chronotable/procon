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

int s[200];

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  int n, k;
  scanf("%d%d", &n, &k);
  for(int i = 0; i < n; i++)
    scanf("%d", s+i);
  sort(s, s+n);
  double ans = 0;
  for(int i = n-k; i < n; i++)
    ans = (ans + s[i]) / 2.0;
  printf("%.7f\n", ans);

  return 0;
}
