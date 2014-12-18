#include <iostream>
#include <string>
#include <stdlib.h>

using namespace std;

int main() {
  char* data = new char[1000000];
  while(true) {
    //cin >> s;
    scanf("%s", data);
    //string s(data);
    //if(s == ".") break;
    if(strcmp(data,".") == 0) break;
    int n = 1;
    int sps = 1;
    int len = strlen(data);
    while(len / 2 >= sps) {
      if(len % sps != 0) {
        sps++;
        continue;
      }
      //string origin(data,sps);
      //char* p = data;
      int a = 1;
      int i;
      for(i = sps;i + sps <= len;i += sps) {
        if(memcmp(data,data+i,sps) == 0) {
          a++;
        }else {
          break;
        }
      }
      if(a > n && i == len) n = a;
      sps++;
    }
    cout << n << endl;
  }

  return 0;
}