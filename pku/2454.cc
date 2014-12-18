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
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  int K;
  scanf("%d", &K);
  pair<int, int> a[200];
  for(int i = 0; i < K*3; i++){
    scanf("%d", &a[i].first);
    a[i].second = i+1;
  }
  sort(a, a+3*K);
  for(int i = 0; i < K; i++)
    printf("%d\n", a[i].second);
  pair<int, int> b[100], c[100];
  int bs = 0, cs = 0;
  for(int i = K, j = 0; i < K*3; i+=2, j++){
    b[j] = a[i]; bs += b[j].first;
    c[j] = a[i+1]; cs += c[j].first;
  }
  int half = 500*K;
  while(cs <= half || bs <= half){
    int x = rand() % K, y = rand() % K;
    if(bs < cs && b[y].first > c[x].first)swap(x, y);
    else if(bs > cs && b[y].first < c[x].first)swap(x, y);
    bs = bs - b[y].first + c[x].first;
    cs = cs - c[x].first + b[y].first;
    swap(b[y], c[x]);
  }
  for(int i = 0; i < K; i++)printf("%d\n", b[i].second);
  for(int i = 0; i < K; i++)printf("%d\n", c[i].second);

  return 0;
}
