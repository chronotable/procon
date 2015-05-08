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

map< vector<int>, int > mem;

void print_vec(vector<int> v){
  for(size_t i = 0; i < v.size(); i++)printf("%d ", v[i]);
  printf("¥n");
}

class LittleElephantAndIntervalsDiv2{
public:
  void dfs(vector<int> b, vector<int>& L, vector<int>& R, int depth){
    if(depth == L.size()){/*print_vec(b);*/ mem[b] = 1; return;}
    for(int i = 0; i < 2; i++){
      for(int j = L[depth]-1; j < R[depth]; j++){
        b[j] = i;
      }
      dfs(b, L, R, depth+1);
    }
  }
  int getNumber(int M, vector<int> L, vector<int> R){
    vector<int> balls(M, 0);
    mem.clear();
    dfs(balls, L, R, 0);
    return mem.size();
  }
};
