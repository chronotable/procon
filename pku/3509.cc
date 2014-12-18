#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

bool check(int* a, int* b, int len){
  int start = -1;
  for(int i = 0; i < len; i++){
    if(a[0] == b[i]){
      start = i;
      break;
    }
  }
  if(start < 0)return false;
  for(int i = 1; i < len; i++){
    if(a[i] != b[(start + i) % len])return false;
  }
  return true;
}

  int a[1001][1001];
  int b[1001][1001];
  int as[4001];
  int bs[4001];

int main(){
  int n;
  int count;
  for(int o = 1;;o++){
    scanf("%d", &n);
    if(n == 0)break;
    count = 1;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        scanf("%d", &a[i][j]);
        b[i][j] = count++;
      }
    }
    int m = n / 2;
    bool ok = true;
    for(int r = 0; r < m; r++){
      int outlen = 0;
      int row, col;
      row = r;
      for(int i = r; i < n - r; i++){
        as[outlen] = a[row][i];
        bs[outlen++] = b[row][i];
      }
      col = n-r-1;
      for(int i = r+1; i < n - r; i++){
        as[outlen] = a[i][col];
        bs[outlen++] = b[i][col];
      }
      row = n-r-1;
      for(int i = n - r - 2; i >= r; i--){
        as[outlen] = a[row][i];
        bs[outlen++] = b[row][i];
      }
      col = r;
      for(int i = n - r - 2; i > r; i--){
        as[outlen] = a[i][col];
        bs[outlen++] = b[i][col];
      }
      if(!check(as, bs, outlen)){
        ok = false;
        break;
      }
    }
    if(n % 2 == 1){
      if(a[m][m] != b[m][m])ok = false;
    }
    printf("%d. %s\n", o, ok ? "YES" :"NO");
  }

  return 0;
}

