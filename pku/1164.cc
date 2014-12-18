#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <algorithm>
#include <string.h>
#include <vector>

using namespace std;

int h,w;
int u[51][51];
int f[51][51];
const int dx[4] = {-1, 0, 1, 0};
const int dy[4] = {0, -1, 0, 1};

void init(){
  for(int i = 0; i < 51; i++)
    for(int j = 0; j < 51; j++){
      u[i][j] = f[i][j] = 0;
    }
}

int tra(int y, int x){
  if(u[y][x])
    return 0;
  u[y][x] = 1;
  int ret = 1;
  for(int i = 0; i < 4; i++)
    if(!(f[y][x] >> i & 1))
      ret += tra(y + dy[i], x + dx[i]);
  return ret;
}

int main(int argc, char* argv[]){

  for(;~scanf("%d%d", &h, &w);){
    init();
    for(int i = 0; i < h; i++)
      for(int j = 0; j < w; j++)
        scanf("%d", &f[i][j]);
    int room = 0;
    int mx = 0;
    for(int i = 0; i < h; i++)
      for(int j = 0; j < w; j++)
        if(!u[i][j]){
          int res = tra(i, j);
          if(res > mx)mx = res;
          room++;
        }
    printf("%d\n%d\n", room, mx);
  }

  return 0;
}
