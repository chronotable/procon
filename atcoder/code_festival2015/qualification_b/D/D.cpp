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

int n;
int s[1<<18];
int c[1<<18];

int main(){
  scanf("%d", &n);
  for(int i = 0; i < n; i++)scanf("%d%d", s+i, c+i);
  set< pair<ll, ll> > span;
  set< pair<ll, ll> >::iterator it;
  for(int i = 0; i < n; i++){
    ll rest = c[i];
    it = span.lower_bound(make_pair(s[i], 0));
    if(it != span.begin())it--;
    ll prev = s[i];
    ll min_start = s[i];
    set< pair<ll, ll> > cands;
    //printf("start (%d %d)\n", s[i], c[i]);
    while(rest > 0 && it != span.end()){
      ll start = it->first;
      ll end = it->second;
      if(prev > end){
        it++;
        continue;
      }
      ll white = max(start - prev, 0ll);
      min_start = min(min_start, start);
      //printf("span(%lld %lld) and rest=%lld white=%lld\n", start, end, rest, white);
      if(rest <= white){
        printf("%lld\n", prev + rest - 1);
        span.insert(make_pair(min_start, prev + rest - 1));
        rest = 0;
        break;
      }else{
        rest -= white;
        //span.erase(it);
        cands.insert(*it);
        prev = end + 1;
      }
      it++;
    }
    if(rest > 0){
      printf("%lld\n", prev + rest - 1);
      span.insert(make_pair(min_start, prev + rest - 1));
    }
    for(it = cands.begin(); it != cands.end(); it++)
      span.erase(*it);
  }

  return 0;
}
