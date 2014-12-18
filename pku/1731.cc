#include <iostream>
#include <stdio.h>
#include <string.h>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
  char s[300];
  scanf("%s",s);
  int n = strlen(s);
  sort(s, s + n);
  do{
    printf("%s\n", s);
  }while(next_permutation(s, s+n));
  return 0;
}
