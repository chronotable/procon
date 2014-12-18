#include <iostream>
#include <stdio.h>
using namespace std;

int main(){
  int T,h,m;
  scanf("%d", &T);
  for(;T;T--){
    scanf("%d:%d",&h,&m);
    if(m != 0)
      cout << 0 << endl;
    else if(h < 13)
      cout << h+12 << endl;
    else
      cout << h-12 << endl;
  }
  return 0;
}