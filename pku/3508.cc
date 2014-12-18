#include <iostream>
#include <stdio.h>
#include <string.h>

char buf[1000001];
char ans[1000001];
int main(){

  for(int o = 1;;o++){
    scanf("%s", buf);
    int len = strlen(buf);
    if(len == 1 && buf[0] == '0')break;
    int crr = 0;
    ans[len] = '\0';
    ans[len-1] = buf[len-1];
    int prev = buf[len-1] - '0';
    for(int i = len-2; i >= 0; i--){
      int v = buf[i] - '0' - crr;
      if(v < prev){
        v += 10;
        crr = 1;
      }else{
        crr = 0;
      }
      ans[i] = v - prev + '0';
      prev = v - prev;
    }
    printf("%d. %s\n", o, ans[0] == '0' ? "IMPOSSIBLE" : ans);
  }

  return 0;
}
