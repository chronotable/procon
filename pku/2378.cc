#include <stdio.h>
#include <stdlib.h>

#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>

using namespace std;

vector < vector<int> > graph(10001);
vector <int> ans;
bool used[10001];
int n;

int traverse(int cur){
  used[cur] = true;
  int ret = 1;
  int mx = 0;
  for(int i = 0; i < graph[cur].size(); i++){
    if(used[graph[cur][i]])continue;
    int v = traverse(graph[cur][i]);
    mx = max(mx, v);
    ret += v;
  }
  mx = max(n - ret, mx);
  if(mx * 2 <= n)ans.push_back(cur);
  return ret;
}

int main(){
  scanf("%d", &n);
  for(int i = 1; i < n; i++){
    int a, b;
    scanf("%d%d", &a, &b);
    a--; b--;
    graph[a].push_back(b);
    graph[b].push_back(a);
  }
  traverse(0);

  if(ans.size() == 0){
    printf("NONE\n");
  }else{
    sort(ans.begin(), ans.end());
    for(int i = 0; i < ans.size(); i++)
      printf("%d\n", ans[i]+1);
  }

  return 0;
}
