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

#define M 10001

int n;
int a[M];

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  int T, o;
  for(scanf("%d", &T); T--; ){
    scanf("%d%d", &o, &n);
    int total = 0;
    for(int i = 0; i < n; i++){
      scanf("%d", a+i);
      total += a[i];
    }
    int cur = 0;
    for(int i = 0; i < n; i++){
      cur += a[i];
      if(total % cur)
        continue;
      int temp = 0;
      bool ok = true;
      for(int j = i+1; j < n; j++){
        temp += a[j];
        if(temp == cur)temp = 0;
        else if(temp > cur){
          ok = false;
          break;
        }
      }
      if(ok){
        printf("%d %d\n", o, cur);
        break;
      }
    }
  }

  return 0;
}
