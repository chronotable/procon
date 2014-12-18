#include <iostream>
using namespace std;

int main(){

  int t;
  bool black[101][101];
  for(int i = 0; i < 101; i++)
    for(int j = 0; j < 101; j++)
      black[i][j] = false;
  cin >> t;
  for(int i = 0; i < t;i++){
    string cmd;
    int x,y,len;
    cin >> cmd >> x >> y >> len;
    if(cmd == "BLACK"){
      for(int j = y; j < y + len; j++)
        for(int k = x; k < x + len; k++)
          black[j][k] = true;
    }else if(cmd == "WHITE"){
      for(int j = y; j < y + len; j++)
        for(int k = x; k < x + len; k++)
          black[j][k] = false;
    }else if(cmd == "TEST"){
      int sum = 0;
      for(int j = y; j < y + len; j++)
        for(int k = x; k < x + len; k++)
          if(black[j][k])sum++;
      cout << sum << endl;
    }
  }

  return 0;
}
