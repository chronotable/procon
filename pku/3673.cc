#include <iostream>
#include <stdio.h>
#include <string.h>

using namespace std;

int main(){
  char a[20];
  char b[20];
  scanf("%s", a);
  scanf("%s", b);
  int ans = 0;
  for(int i = 0; i < strlen(a); i++){
    for(int j = 0; j < strlen(b); j++){
      ans += (a[i] - '0') * (b[j] - '0');
    }
  }
  printf("%d\n", ans);

  return 0;
}
