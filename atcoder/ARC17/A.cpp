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

int main(){
  //cin.tie(0);
  //ios_base::sync_with_stdio(false);

  int n;
  cin >> n;
  bool prime = true;
  for(int i = 2; i < n; i++)
    if(n % i == 0)
      prime = false;
  printf("%s\n", prime?"YES":"NO");

  return 0;
}
