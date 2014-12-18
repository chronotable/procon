#include <iostream>
#include <stdio.h>
using namespace std;

int main(){
  char t[100][30];
  for(;;){
    int c,r;
    cin >> c;
    if(!c)break;
    string s;
    cin >> s;
    r = s.size() / c;
    int ind = 0;
    for(int i = 0; i < r; i++){
      if(i % 2){
        for(int j = c-1; j >= 0; j--)t[i][j] = s[ind++];
      }else{
        for(int j = 0; j < c; j++)t[i][j] = s[ind++];
      }
      t[i][c] = '\0';
    }
    for(int i = 0; i < c; i++){
      for(int j = 0; j < r; j++)printf("%c", t[j][i]);
    }
    printf("\n");
  }

  return 0;
}
