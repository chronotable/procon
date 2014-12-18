#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
  int o;
  scanf("%d", &o);
  for(;o;o--){
    int n;
    scanf("%d", &n);
    int w,h;
    vector<int> ar;
    vector<int> u;
    for(int i = 0; i < n; i++){
      scanf("%d%d", &w, &h);
      ar.push_back(w * 100000 + h);
      u.push_back(0);
    }
    sort(ar.begin(), ar.end());
    int ans = 0;
    int prev = 1000000;
    for(int i = 0; i < n; i++){
      if(u[i])continue;
      u[i] = 1;
      ans++;
      prev = ar[i] % 100000;
      for(int j = i + 1; j < n; j++){
        if(u[j])continue;
        h = ar[j] % 100000;
        if(prev <= h){
          u[j] = 1;
          prev= h;
        }
      }
    }
    printf("%d\n", ans);
  }
}
