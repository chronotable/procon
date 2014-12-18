#include <stdio.h>
#include <vector>
#include <iostream>

using namespace std;

int main(){
  int hash[251];
  int n,b,k;
  int elevation[251][251];
  int ans[250*300];
  scanf("%d%d%d", &n, &b, &k);

  for(int i = 0; i < 250*300; i++)ans[i] = 0;

  for(int i = 0; i < n; i++)
    for(int j = 0; j < n; j++)
      scanf("%d", &elevation[i][j]);
  for(int i = 0; i <= n - b; i++){
    for(int j = 0; j <= 250; j++)hash[j] = 0;
    int min = 1000;
    int max = -1;
    for(int y = i; y < i + b; y++){
      for(int j = 0; j < b; j++){
        hash[elevation[y][j]]++;
        if(min > elevation[y][j])
          min = elevation[y][j];
        if(max < elevation[y][j])
          max = elevation[y][j];
      }
    }
    ans[i*300] = max - min;
    //printf("%d ", max-min);
    for(int j = 1; j <= n-b; j++){
      for(int a = 0; a < b; a++){
        int v = elevation[i+a][j-1];
        hash[v]--;
        if(hash[v] == 0){
          if(v == max){
            while(max >= 0 && hash[max] == 0)max--;
          }
          if(v == min){
            while(min <= 250 && hash[min] == 0)min++;
          }
        }
      }
      for(int a = 0; a < b; a++){
        int v = elevation[i+a][j+b-1];
        hash[v]++;
        if(max < v)max = v;
        if(min > v)min = v;
      }
      ans[i*300 + j] = max - min;
      //printf("%d ", max-min);
    }
    //printf("\n");
  }

  int r,c;
  for(; k > 0; k--){
    scanf("%d%d", &r, &c);
    printf("%d\n", ans[(r-1)*300 + c-1]);
  }

  return 0;
}
