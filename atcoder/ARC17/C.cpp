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

int n, x;
int w[50];
map<int, int> c;

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  scanf("%d%d", &n, &x);
  for(int i = 0; i < n; i++)
    scanf("%d", w+i);
  int h = n/2;
  c.clear();
  int lim = 1<<h;
  for(int m = 0; m < lim; m++){
    int sum = 0;
    for(int i = 0; i < h; i++)
      if((m>>i)&1)
        sum += w[i];
    c[sum]++;
  }
  int g = n-h;
  ll ans = 0;
  lim = 1<<g;
  for(int m = 0; m < lim; m++){
    int sum = 0;
    for(int i = 0; i < g; i++)
      if((m>>i)&1)
        sum += w[h+i];
    if(x-sum >= 0)
      ans += c[x-sum];
  }
  cout << ans << endl;

  return 0;
}
