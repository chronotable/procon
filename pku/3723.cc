#include <iostream>
#include <vector>
#include <algorithm>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

class Edge{
public:
  int s,e;
  int cost;
  Edge(int a, int b, int c){
    s=a;e=b;cost=c;
  }
  bool operator < (const Edge p) const{
    return cost > p.cost;
  }
};

int root(int a, int par[]){
  if(a==par[a])return a;
  par[a] = root(par[a], par);
  return par[a];
}

int main(){
  int o;
  scanf("%d", &o);
  for(;o > 0; o--){
    int n,m,r;
    scanf("%d%d%d", &n, &m, &r);
    int t = n+m;
    int par[20001];
    for(int i = 0; i < t; i++)par[i] = i;
    vector<Edge> es = vector<Edge>();
    for(int i = 0; i < r; i++){
      int x,y,d;
      scanf("%d%d%d", &x, &y, &d);
      es.push_back(Edge(x, y + n, d));
    }
    sort(es.begin(), es.end());
    int ans = 10000 * t;
    for(int i = 0; i < r; i++){
      int pa = root(es[i].s, par);
      int pb = root(es[i].e, par);
      if(pa != pb){
        ans -= es[i].cost;
        par[par[pa]] = par[pb];
      }
    }
    printf("%d\n", ans);
  }

  return 0;
}
