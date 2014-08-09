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
char s[1000010];
char t[2000010];

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  scanf("%s", s);
  n = strlen(s);
  memset(t, '-', sizeof(t));
  for(int i = 0; i < n; i++)t[i*2] = s[i];
  int cur = 5;
  int combo = 0;
  ll ans = 0;
  vector< pair<int, int> > q; // time, kaburin
  vector< pair<int, int> > history; // combo, 0: normal, 1:charge
  n *= 2;
  int charge = 0;
  for(int i = 0; i < n; i++){
    vector< pair<int, int> > r;
    for(int j = 0; j < q.size(); j++){
      if(q[j].first == i){
        if(q[j].second < 0)cur -= q[j].second;
        else combo++;
      }else
        r.push_back(q[j]);
    }
    q = r;
    if(charge-- > 0)continue;
    //printf("%d: %c cur=%d\n", i, t[i], cur);
    if(t[i] == 'N' && cur >= 1){
      cur--;
      history.push_back(make_pair(combo, 0));
      q.push_back(make_pair(i+3, 1));
      q.push_back(make_pair(i+13, -1));
    }else if(t[i] == 'C' && cur >= 3){
      cur -= 3;
      history.push_back(make_pair(combo, 1));
      q.push_back(make_pair(i+7, 1));
      q.push_back(make_pair(i+17, -3));
      //i += 4;
      charge = 4;
    }
  }
  sort(history.begin(), history.end());
  for(int i = 0; i < history.size(); i++){
    int type = history[i].second;
    int c = history[i].first;
    if(type == 0){
      ans += 10 + c/10;
    }else{
      ans += 50 + c/10 * 5;
    }
  }
  cout << ans << endl;

  return 0;
}
