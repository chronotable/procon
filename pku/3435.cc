#include <iostream>
#include <stdio.h>

using namespace std;

int main(){
  int m,n;
  int b[101][101];
  cin >> m;
  n = m*m;
  for(int i = 0; i < n; i++)
    for(int j = 0; j < n; j++)
      cin >> b[i][j];
  //check row
  for(int i = 0; i < n; i++){
    bool u[101];
    for(int j = 0; j <= n; j++)u[j] = false;
    for(int j = 0; j < n; j++){
      if(b[i][j] == 0)continue;
      if(u[b[i][j]]){
        cout << "INCORRECT" << endl;
        return 1;
      }
      u[b[i][j]] = true;
    }
  }
  //check column
  for(int i = 0; i < n; i++){
    bool u[101];
    for(int j = 0; j <= n; j++)u[j] = false;
    for(int j = 0; j < n; j++){
      if(b[j][i] == 0)continue;
      if(u[b[j][i]]){
        cout << "INCORRECT" << endl;
        return 1;
      }
      u[b[j][i]] = true;
    }
  }

  //check block
  for(int i = 0; i < m; i++){
    for(int j = 0; j < m; j++){
      int sy = i * m;
      int sx = j * m;
      int ey = (i+1) * m;
      int ex = (j+1) * m;
      bool u[101];
      for(int j = 0; j <= n; j++)u[j] = false;
      for(int y = sy; y < ey; y++){
        for(int x = sx; x < ex; x++){
          if(b[y][x] == 0)continue;
          if(u[b[y][x]]){
            cout << "INCORRECT" << endl;
            return 1;
          }
          u[b[y][x]] = true;
        }
      }
    }
  }

  cout << "CORRECT" << endl;

  return 0;
}
