#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
  for(;;){
    int r,n;
    scanf("%d%d",&r,&n);
    if(r==-1 && n==-1)break;
    int x;
    vector<int> cd;
    for(int i = 0; i < n; i++){
      scanf("%d",&x);
      cd.push_back(x);
    }
    sort(cd.begin(), cd.end());
    int ans = 0;
    for(int i = 0; i < n;){
      ans++;
      int left = cd[i];
      while(i < n && cd[i] - left <= r)i++;
      i--;
      int mid = cd[i];
      while(i < n && cd[i] - mid <= r)i++;
    }
    printf("%d\n",ans);
  }

  return 0;
}
