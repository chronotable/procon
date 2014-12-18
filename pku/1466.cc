#include <iostream>
#include <vector>
#include <stdio.h>
#include <cstring>

using namespace std;

const int MAX = 501;

//vector<int> ivecL, ivecR;
vector<int> ivecV[MAX];
bool visit[MAX];
int n, match[MAX];

bool dfs(int u){
  for(int i = 0; i < ivecV[u].size(); i++){
    int v = ivecV[u][i];
    if(!visit[v]){
      visit[v] = true;
      if(match[v] < 0 || dfs(match[v])){
        match[v] = u;
        match[u] = v;
        return true;
      }
    }
  }
  return false;
}

int maxMatch(){
  int sum = 0;
  //memset(match, -1, sizeof(match));
  for(int i = 0; i < MAX; i++)match[i] = -1;
  for(int i = 0; i < n; i++){
    if(match[i] < 0){
      //memset(visit, false, sizeof(visit));
      for(int j = 0; j < MAX; j++)visit[j] = false;
      visit[i] = true;
      if(ivecV[i].size() > 0 && dfs(i))
        sum++;
    }
  }
  return sum;
}

int main(){
  while(scanf("%d", &n) != EOF){
    int i, u, v, m;
    for(i = 0; i < n; i++)ivecV[i].clear();
    for(i = 0; i < n; i++){
      scanf("%d: (%d)", &u, &m);
      while(m--){
        scanf("%d", &v);
        ivecV[u].push_back(v);
        ivecV[v].push_back(u);
      }
    }
    printf("%d\n", n - maxMatch());
  }

  return 0;
}
