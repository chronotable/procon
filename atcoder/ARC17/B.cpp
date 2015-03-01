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

int n, k;
int a[300100];

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  scanf("%d%d", &n, &k);
  for(int i = 0; i < n; i++)
    scanf("%d", a+i);
  int ans = 0;
  int cur = 1;
  for(int i = 1; i < n; i++){
    if(cur >= k){
      ans++;
      //printf("%d\n", i);
    }
    if(a[i-1] >= a[i]){
      cur = 1;
    }else{
      cur++;
    }
  }
  if(cur >= k)
    ans++;
  cout << ans << endl;

  return 0;
}
