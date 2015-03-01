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

#define M (401)

int n;
vector<string> large;
vector<int> m;
vector<string> small;
map<string, int> s2i;
map<int, string> i2s;
double graph[M][M];
set<string> names;
vector<string> units;
int node;

int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(false);

  cin >> n;
  for(int i = 0; i < n; i++){
    string s, l;
    int a;
    cin >> l >> a >> s;
    large.push_back(l); m.push_back(a); small.push_back(s);
    names.insert(l); names.insert(s);
  }
  for(set<string>::iterator it = names.begin(); it != names.end(); it++)
    units.push_back(*it);
  node = units.size();
  for(int i = 0; i < node; i++){
    s2i[units[i]] = i;
    i2s[i] = units[i];
  }
  memset(graph, 0, sizeof(graph));
  for(int i = 0; i < n; i++){
    int li = s2i[large[i]];
    int si = s2i[small[i]];
    graph[li][si] = m[i];
    graph[si][li] = 1.0/m[i];
  }
  for(int k = 0; k < node; k++)
    for(int i = 0; i < node; i++){
      for(int j = 0; j < node; j++){
        if(graph[i][k] && graph[j][k]){
          graph[i][j] = graph[i][k] * graph[k][j];
          graph[j][i] = 1.0 / graph[i][j];
        }
      }
    }
  double ans = 0;
  int start = -1, end = -1;
  for(int i = 0; i < node; i++)
    for(int j = 0; j < node; j++)
      if(graph[i][j] > ans){
        ans = graph[i][j];
        start = i; end = j;
      }
  /*
  vector< vector<int> > con(node);
  for(int i = 0; i < node; i++)
    for(int j = 0; j < node; j++)
      if(graph[i][j])
        con[i].push_back(j);
  double ans = 0;
  int start = -1, end = -1;
  for(int i = 0; i < node; i++){
    double mx = 1;
    int where = -1;
    double memo[M];
    for(int j = 0; j < node; j++)memo[j] = 0;
    queue< pair<double, int> > q;
    q.push(make_pair(1, i));
    memo[i] = 1;
    while(!q.empty()){
      pair<double, int> p = q.front(); q.pop();
      int w = p.second;
      double d = p.first;
      if(memo[w] > d)
        continue;
      if(mx < d){
        mx = d;
        where = w;
      }
      for(int j = 0; j < con[w].size(); j++){
        int k = con[w][j];
        if(memo[j] < d * graph[w][k]){
          memo[j] = d * graph[w][k];
          q.push(make_pair(memo[j], k));
        }
      }
    }
    if(mx > ans){
      ans = mx;
      start = i; end = where;
    }
  }
  */
  cout << "1" << i2s[start] << "=" << (int)(ans+0.5) << i2s[end] << endl;
  

  return 0;
}
