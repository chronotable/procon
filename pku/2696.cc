#include <iostream>
#include <stdio.h>

using namespace std;

int a,b,c,d,e,f,g,h;
int memo[10001];
int func(int i){
  if(memo[i] >= 0)return memo[i];
  if(i == 0)return a;
  if(i == 1)return b;
  if(i == 2)return c;
  if(i % 2 == 1){
    memo[i] = (d*func(i-1) + e*func(i-2) - f*func(i-3));
    if(memo[i] < 0){
      int abs = - memo[i];
      int div = abs / g;
      if(abs % g > 0)div++;
      memo[i] += div * g;
    }else{
      memo[i] %= g;
    }
  }else{
    memo[i] = (f*func(i-1) - d*func(i-2) + e*func(i-3)) % h;
    if(memo[i] < 0){
      int abs = - memo[i];
      int div = abs / h;
      if(abs % h > 0)div++;
      memo[i] += div * h;
    }else{
      memo[i] %= h;
    }
  }

  return memo[i];
}

int main(){
  int n,i;
  cin >> n;
  for(;n;n--){
    cin >> a >> b >> c >> d >> e >> f >> g >> h >> i;
    for(int j = 0; j < 10001; j++)memo[j] = -1;
    cout << func(i) << endl;
  }

  return 0;
}
