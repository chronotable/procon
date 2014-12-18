#include <iostream>
#include <string.h>
#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

int calc(int n, int m){
  int s = 0;
  for(int i = 2; i < n; i++)s = (s+m) % i;
  return s+1;
}

int main(int argc, char* argv[]){
  int n;
  
  for(;;){
    cin >> n;
    if(!n)break;
    for(int m = 2; ; m++)
      if(calc(n, m) == 1){cout << m << endl;break;}
  }
  return 0;
}

/*
int main(int argc, char* argv[]){
  int n;
  int ans[151];
  memset(ans, 0, sizeof(ans));
  
  for(;;){
    cin >> n;
    if(!n)break;
    if(ans[n]){
      cout << ans[n] << endl;
      continue;
    }
    int u[150];
    int rest;
    for(int m = 2; ; m++){
      memset(u, 0, sizeof(u));
      u[0] = 1;
      int cur = 1;
      rest = n-1;
      while(rest > 1){
        int p = (m-1) % rest;
        //if(p == 0)p = m;
        for(int j = 0; j <= p;){
          if(u[cur] == 0){
            j++;
            if(j > p)break;
          }
          cur = (cur+1) % n;
        }
        u[cur] = 1;
        cur = (cur+1)%n;
        while(u[cur])cur = (cur+1)%n;
        rest--;
      }
      if(u[1] == 0){
        ans[n] = m;
        cout << m << endl;
        break;
      }
    }
  }

  return 0;
}
*/
