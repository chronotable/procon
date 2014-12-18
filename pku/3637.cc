#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
  int t;
  scanf("%d", &t);
  int price[20001];
  for(;t > 0;t--){
    int n;
    scanf("%d", &n);
    for(int i = 0; i < n; i++)scanf("%d", price + i);
    sort(price, price+n);
    int ans = 0;
    for(int i = n-3; i >= 0; i -= 3)ans += price[i];
    printf("%d\n", ans);
  }

  return 0;
}
