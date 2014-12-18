#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>
#include <stdio.h>

using namespace std;

int main(){
  int T;
  int x[20];
  int y[20];
  for(scanf("%d",&T);T;T--){
    int w,h;
    int sx, sy;
    int n;
    vector<int> id;
    //cin >> w >> h >> sx >> sy >> n;
    scanf("%d%d%d%d%d",&w,&h,&sx,&sy,&n);
    for(int i = 0; i < n; i++){
      //cin >> x[i] >> y[i];
      scanf("%d%d", x+i, y+i);
      id.push_back(i);
    }
    int ans = 10000000;
    do{
      int cx = sx, cy = sy;
      int sum = 0;
      for(int i = 0; i < n; i++){
	sum += abs(cx - x[id[i]]) + abs(cy - y[id[i]]);
	cx = x[id[i]];
	cy = y[id[i]];
      }
      sum += abs(cx - sx) + abs(cy - sy);
      if(ans > sum)ans = sum;
    }while(next_permutation(id.begin(), id.end()));
    //cout << "The shortest path has length " << ans << endl;
    printf("The shortest path has length %d\n", ans);
  }

  return 0;
}