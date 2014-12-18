#include <iostream>
#include <vector>
#include <algorithm>

#include <stdio.h>

using namespace std;

int main(int argc, char* argv[]){
  int n, z, m, v;
  bool obstacle[1001] = {false};

  scanf("%d%d%d", &n, &z, &m);
  z--;
  for(int i = 0; i < m; i++){
    scanf("%d", &v);
    obstacle[v-1] = true;
  }

  int ans = 1;
  for(;;ans++){
    bool u[1001] = {false};
    int pos;
    for(pos = 0; !u[pos] && !obstacle[pos];){
      if(pos == z)break;
      u[pos] = true;
      pos = (pos + ans) % n;
    }
    if(pos == z)break;
  }
  printf("%d\n", ans);

  return 0;
}
