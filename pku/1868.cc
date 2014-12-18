#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

int main(){
  int n,v;
  int a[10003];
  char c;
  while(scanf("%d%c", &n, &c) != EOF && n){
    bool flag = false;
    for(int i = 0; i < n; i++){
      scanf("%d", &v);
      a[v] = i;
    }
    for(int i = 0; i < n; i++){
      for(int j = i+1; 2*j-i < n; j++){
        int k = 2*j-i;
        if((a[k] > a[j] && a[j] > a[i]) || (a[k] < a[j] && a[j] < a[i])){
          flag = true;
        }
      }
      if(flag)break;
    }
    printf("%s\n", flag ? "no" : "yes");
  }
}
