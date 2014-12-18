#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int tbl[10001][40];

int main(){
  int n,q,m;
  int a,b;
  for(int i = 0; i < 10001; i++)for(int j = 0; j < 40; j++)tbl[i][j] = 0;
  scanf("%d", &n);
  for(int i = 0; i < n; i++){
    int s;
    scanf("%d", &s);
    int ind = i / 32;
    int bit = i % 32;
    int v;
    for(int j = 0; j < s; j++){
      scanf("%d", &v);
      tbl[v][ind] |= 1 << bit;
    }
  }
  m = n / 32 + 1;
  scanf("%d", &q);
  for(;q;q--){
    scanf("%d %d", &a, &b);
    bool yes = false;
    for(int i = 0; i < m; i++)
      if(tbl[a][i] & tbl[b][i]){
        yes = true;
        break;
      }
    printf("%s\n", yes ? "Yes" : "No");
  }

  return 0;
}
