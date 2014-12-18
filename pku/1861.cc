#include <iostream>
#include <vector>
#include <algorithm>
#include <stdio.h>

using namespace std;

class E{
public:
  int s,e;
  int w;

  E(){
    ;
  }
  E(int a, int b, int c);

  bool operator<(const E& e) const{
    return w < e.w;
  }
};

E::E(int a, int b, int c){
  s = a;
  e = b;
  w =c;
}

int par[1001];

int root(int a){
  if(par[a] == a)return a;
  par[a] = root(par[a]);
  return par[a];
}

int uni(int a, int b){
  return par[root(b)] = par[par[root(a)]];
}

int main(){
  int n,m;
  int p = 0;
  int mx = -1;
  scanf("%d%d", &n, &m);

  for(int i = 1; i <= 1000; i++)par[i] = i;
  vector<E> edges;
  E use[20000];

  for(int i = 0; i < m; i++){
    int s,e,w;
    scanf("%d%d%d", &s, &e, &w);
    edges.push_back(E(s,e,w));
  }
  sort(edges.begin(), edges.end());
  for(int i = 0; i < m; i++){
    E t = edges[i];
    if(root(t.s) != root(t.e)){
      use[p++] = t;
      uni(root(t.s), root(t.e));
      if(mx < t.w)mx = t.w;
    }
  }

  printf("%d\n", mx);
  printf("%d\n", p);
  for(int i = 0; i < p; i++){
    printf("%d %d\n", use[i].s, use[i].e);
  }

  return 0;
}