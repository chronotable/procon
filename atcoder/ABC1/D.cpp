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

#define M (30010)

int n;

inline void printTime(int t){
  printf("%02d%02d", t/60, t%60);
}

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  scanf("%d", &n);
  char s[10];
  vector< pair<int, int> > a(n);
  for(int o = 0; o < n; o++){
    scanf("%s", s);
    int sh = (s[0] - '0') * 10 + s[1] - '0';
    int sm = (s[2] - '0') * 10 + s[3] - '0';
    if(sm % 5)sm -= sm % 5;
    int eh = (s[5] - '0') * 10 + s[6] - '0';
    int em = (s[7] - '0') * 10 + s[8] - '0';
    if(em % 5)em += 5 - (em % 5);
    if(em == 60){
      em = 0; eh++;
    }
    a[o] = make_pair(sh*60+sm, eh*60+em);
  }
  sort(a.begin(), a.end());
  //for(int i = 0; i < n; i++){printTime(a[i].first); printf("-"); printTime(a[i].second); puts("");}
  for(int i = 0; i < n;){
    printTime(a[i].first); printf("-");
    int et = a[i].second;
    //int eh = a[i].second / 60;
    //int em = a[i].second % 60;
    i++;
    while(i < n){
      if(et >= a[i].first){
        et = max(et, a[i].second);
        i++;
      }else{
        break;
      }
    }
    printTime(et); printf("\n");
  }

  return 0;
}
