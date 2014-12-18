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

#define M 16000000

int n, nc;
char s[M];
int ind[256];
bool used[M];

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  scanf("%d%d%s", &n, &nc, s);
  unsigned int m = (unsigned int)nc;
  unsigned int r = 1;
  unsigned int cur = 0;
  int len = strlen(s);
  if(len < n){
    printf("0\n");
    return 0;
  }
  for(int i = 0; i < 256; i++)ind[i] = -1;
  int count = 0;
  for(int i = 0; i < len; i++)
    if(ind[s[i]] == -1)
      ind[s[i]] = count++;
  for(int i = 0; i < n; i++){
    cur = cur * m + ind[s[i]];
    r *= m;
  }
  int ans = 1;
  used[cur] = true;
  for(int i = n; i < len; i++){
    cur *= m;
    cur += ind[s[i]];
    cur -= r * (ind[s[i-n]]);
    if(!used[cur]){
      ans++;
      used[cur] = true;
    }
  }
  printf("%d\n", ans);

  return 0;
}
