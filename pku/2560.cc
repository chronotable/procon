#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <stdio.h>

using namespace std;

class E{
public:
  int s, t;
  double dis;
  E(int a, int b, double c){
    s = a;
    t = b;
    dis = c;
  }
  bool operator<(const E& e) const{
    return dis < e.dis;
  }
};

int root(int par[], int v){
  if(par[v] == v)return v;
  return par[v] = root(par, par[v]);
}

int merge(int par[], int a, int b){
  par[root(par, b)] = root(par, a);
}

int main(){
  int n;
  cin >> n;
  int t = n * (n-1) / 2;
  //E tbl[10000];
  vector<double> xs;
  vector<double> ys;
  vector<E> es;
  int par[120];
  for(int i = 0; i < n; i++){
    double x,y;
    cin >> x >> y;
    xs.push_back(x);
    ys.push_back(y);
    par[i] = i;
  }
  for(int i = 0; i < n; i++){
    for(int j = i+1; j < n; j++){
      double dis = sqrt((xs[i]-xs[j])*(xs[i]-xs[j]) +
                        (ys[i]-ys[j])*(ys[i]-ys[j]));
      es.push_back(E(i, j, dis));
    }
  }
  sort(es.begin(), es.end());
  double ans = 0;
  int count = n-1;
  for(int i = 0; i < es.size(); i++){
    E e = es[i];
    //printf("%d -> %d = %.2f\n", e.s, e.t, e.dis);
    if(root(par, e.s) != root(par, e.t)){
      merge(par, e.s, e.t);
      ans += e.dis;
      count--;
    }
    if(count == 0)
      break;
  }
  printf("%.2f\n", ans);

  return 0;
}
