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

int c;
int b[2000][3];

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  scanf("%d", &c);
  for(int i = 0; i < c; i++){
    for(int j = 0; j < 3; j++)
      scanf("%d", b[i]+j);
    sort(b[i], b[i]+3);
  }
  int ans = 1;
  for(int j = 0; j < 3; j++){
    int mx = 0;
    for(int i = 0; i < c; i++)
      mx = max(mx, b[i][j]);
    ans *= mx;
  }
      
  /*
  for(int i = 1; i <= 100; i++)
    for(int j = i; j <= 100; j++)
      for(int k = j; k <= 100; k++){
	bool ok = true;
	for(int x = 0; x < c; x++){
	  sort(b[x], b[x]+3);
	  bool f = false;
	  do{
	    if(i >= b[x][0] && j >= b[x][1] && k >= b[x][2]){
	      f = true;
	      break;
	    }
	  }while(next_permutation(b[x], b[x]+3));
	  if(!f){
	    ok = false;
	    break;
	  }
	}
	if(ok)
	  ans = min(ans, i*j*k);
      }
  */
  printf("%d\n", ans);

  return 0;
}
