#include <iostream>

using namespace std;

char tile[21][21];
int w,h;
int c;

void search(int a,int b) {
  if(tile[a][b] != '@') {
    tile[a][b] = '@';
    c++;
  }
  if(a - 1 >= 0 && tile[a - 1][b] == '.') search(a-1,b);
  if(b + 1 < w && tile[a][b + 1] == '.') search(a,b+1);
  if(a + 1 < h && tile[a + 1][b] == '.') search(a+1,b);
  if(b - 1 >= 0 && tile[a][b - 1] == '.' ) search(a,b-1);
}

int main() {
  int s,t;
  while(cin >> w >> h,w + h) {
    for(int i = 0;i < h;i++) {
      //tile[i] = cin.getline();
      scanf("%s",tile[i]);
      for(int j = 0;j < w;j++) {
        if(tile[i][j] == '@') {
          s = i;
          t = j;
        }
      }
    }
    c = 1;
    search(s,t);
    cout << c << endl;
  }

  return 0;
}