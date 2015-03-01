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
int b[100100];

int main(){
  scanf("%d", &n);
  for(int i = 0; i < n; i++)
    scanf("%d", b+i);
  int cur = b[0];
  for(int i = 1; i < n; i++)
    cur ^= b[i];
  if(cur){
    printf("-1\n");
    return 0;
  }
  cur = 0;
  for(int i = 0; i < n; i++){
    printf("%d\n", cur);
    cur ^= b[i];
  }
  if(cur)
    printf("error\n");

  return 0;
}
