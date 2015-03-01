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

#define N (150)
#define S (2000)

vector< pair<int, int> > cs;
bool b[N][N];
//int ind[N][N];
bool exist[S];

void random_try(){
  random_shuffle(cs.begin(), cs.end());
  vector< pair<int, int> > cand(S);
  memset(b, 0, sizeof(b));
  memset(exist, 0, sizeof(exist));
  for(int i = 0; i < S; i++){
    cand[i] = cs[i];
    b[cs[i].first][cs[i].second] = true;
    //ind[cs[i].first][cs[i].second] = i;
    exist[i] = true;
  }
  for(int i = 0; i < S; i++)
    if(exist[i]){
      int y0 = cand[i].first;
      int x0 = cand[i].second;
      for(int j = i+1; j < S; j++)
        if(exist[j]){
          int y1 = cand[j].first;
          int x1 = cand[j].second;
          if(y0 == y1 || x0 == x1)
            continue;
          if(b[y0][x1] && b[y1][x0]){
            exist[j] = false;
            b[y1][x1] = false;
          }
        }
    }
  
  vector< pair<int, int> > c;
  for(size_t i = 0; i < cand.size(); i++)
    if(exist[i])
      c.push_back(cand[i]);
  for(size_t i = S; i < cs.size() && c.size() < 1800; i++){
    int y0 = cs[i].first;
    int x0 = cs[i].second;
    bool ok = true;
    for(size_t j = 0; j < c.size(); j++){
      int y1 = c[j].first;
      int x1 = c[j].second;
      if(y0 == y1 || x0 == x1)
        continue;
      if(b[y0][x1] && b[y1][x0]){
        ok = false;
        break;
      }
    }
    if(ok){
      c.push_back(cs[i]);
      b[y0][x0] = true;
    }
  }
  

  /*
  int sum = 0;
  for(int i = 0; i < S; i++)
    if(exist[i])
      sum++;
  printf("sum=%d\n", sum);
  */
  printf("%d\n", N);
  int sum = 0;
  for(int i = 0; i < N; i++){
    for(int j = 0; j < N; j++){
      printf("%s", b[i][j]?"O":".");
      if(b[i][j])
        sum++;
    }
    printf("\n");
  }
  printf("sum=%d\n", sum);
}

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);
  cs.clear();
  for(int i = 0; i < N; i++)
    for(int j = 0; j < N; j++)
      cs.push_back(make_pair(i, j));
  for(int i = 0; i < 1; i++)
    random_try();

  return 0;
}
