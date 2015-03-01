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

#define INF (1<<30)
#define FNI (-(1<<30))

int min(int a, int b){return a<b?a:b;}
int max(int a, int b){return a>b?a:b;}

int gcd(int x, int y){
  int t;
  while(y != 0){
    t = x % y; x = y; y = t;
  }
  return x;
}

class SRMQ{
public:
  int* a;
  int n;
  int* s;
  int* bias;
  int M;
  int EX;
  int (*cmp)(int, int);
  SRMQ(int* _a, int _n, int (*c)(int, int), int E){
    n = _n;
    a = new int[n];
    for(int i = 0; i < n; i++)a[i] = _a[i];
    M = (int)sqrt(n);
    s = new int[M];
    for(int i = 0; i < M; i++)s[i] = E;
    cmp = c;
    for(int i = 0; i < n; i++){
      if(s[i/M] == E)
        s[i/M] = a[i];
      s[i/M] = cmp(s[i/M], a[i]);
      
    }
    bias = new int[M];
    EX = E;
  }
  ~SRMQ(){
    delete [] a;
    delete [] s;
    delete [] bias;
  }
  // find the value in [x, y]
  int rmq(int x, int y){
    int sx = x / M;
    int sy = y / M;
    int min = EX;
    if(sx == sy){
      min = a[x] + bias[sx];
      for(int i = x; i <= y; i++)
        min = cmp(min, a[i] + bias[sx]);
    }else{
      if(sx+1 <= sy-1)
        min = s[sx+1] + bias[sx+1];
      for(int i = sx + 1; i <= sy - 1; i++)
        min = cmp(min, s[i] + bias[i]);
      int lim = M * (sx + 1);
      if(min == EX && x < lim)
        min = a[x] + bias[sx];
      for(int i = x; i < lim; i++)
        min = cmp(min, a[i] + bias[sx]);
      if(min == EX && M*sy <= y)
        min = a[M*sy] + bias[sy];
      for(int i = M * sy; i <= y; i++)
        min = cmp(min, a[i] + bias[sy]);
    }
    return min;
  }
  
  // add v to [x, y]
  void inc(int x, int y, int v){
    int sx = x / M;
    int sy = y / M;
    if(sx == sy){
      for(int i = x; i <= y; i++)
        a[i] += v;
      update(sx);
    }else{
      for(int i = sx + 1; i <= sy - 1; i++)
        bias[i] += v;
      int lim = M * (sx + 1);
      for(int i = x; i < lim; i++)
        a[i] += v;
      for(int i = M * sy; i <= y; i++)
        a[i] += v;
      update(sx);
      update(sy);
    }
  }
  
  // update minimum for range c
  void update(int c){
    int min = a[c*M];//EX;
    int lim = (c + 1) * M;
    for(int i = c * M; i < lim && i < n; i++)
      min = cmp(min, a[i]);
    s[c] = min;
  }
};


SRMQ* minq, *maxq;
SRMQ* gcdq;
int n, m;
int a[100100];
int t, l, r;

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  scanf("%d", &n);
  for(int i = 0; i < n; i++)scanf("%d", a+i);
  //minq = new SRMQ(a, n, min, INF);
  //maxq = new SRMQ(a, n, max, FNI);
  gcdq = new SRMQ(a, n, gcd, INF);
  scanf("%d", &m);
  for(int o = 0; o < m; o++){
    scanf("%d%d%d", &t, &l, &r);
    l--; r--;
    if(t == 0){
      //int mn = minq->rmq(l, r);
      //int mx = maxq->rmq(l, r);
      //int g = gcd(mx, mn);
      int g = gcdq->rmq(l, r);
      printf("%d\n", g);
    }else{
      //minq->inc(l, r, t); maxq->inc(l, r, t);
      gcdq->inc(l, r, t);
    }
  }

  return 0;
}
