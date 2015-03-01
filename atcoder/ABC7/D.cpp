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

typedef unsigned long long ll;

/*
ll calc(ll n){
  if(n == 0)
    return 0;
  ll temp = n;
  ll last = 0;
  int fig = 0;
  ll dec = 1;
  while(temp){
    fig++;
    dec *= 10ll;
    ll lsf = temp % 10;
    last = temp;
    temp /= 10;
  }
  dec /= 10;
  ll total = 1;
  for(int i = 1; i < fig; i++)
    total *= 8ll;
  ll ans = total;
  if(last == 9)
    ans *= last - 2;
  else if(last > 4)
    ans *= last - 1;
  else
    ans *= last;
  if(last != 4 && last != 9){
    ans += (n%dec) - calc(n % dec);
  }
  return n - ans;
}
*/

ll calc(ll n){
  ll a = 1, b = 0;
  for(ll p = 1000000000000000000ll; p; p /= 10ll){
    ll t = n / p % 10;
    ll c = t;
    if(t > 4)
      c--;
    b = b * 8 + a * c;
    if(t % 5 == 4)
      a = 0;
  }
  return n - a - b;
}

int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(false);

  //cout << calc(1000) << endl;
  //cout << calc(1000000000000000000ll) << endl;

  ll a, b;
  cin >> a >> b;
  ll temp = b;
  cout << calc(b) - calc(a-1) << endl;

  return 0;
}
