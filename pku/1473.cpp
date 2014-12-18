#include <iostream>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

using namespace std;

int main(){
  for(int o = 1;;o++){
    string line;
    cin >> line;
    if(line == "END")break;
    double y = 0, x = 0;
    for(int i = 0; i < line.size(); i++){
      double mag = 0;
      while(line[i] >= '0' && line[i] <= '9'){
        mag = mag * 10 + line[i++] - '0';
      }
      int dx = 0;
      int dy = 0;
      while(line[i] != ',' && line[i] != '.'){
        switch (line[i]){
        case 'N':
          dy++;
          break;
        case 'E':
          dx++;
          break;
        case 'S':
          dy--;
          break;
        case 'W':
          dx--;
          break;
        }
        i++;
      }
      if(abs(dx) == 1 && abs(dy) == 1)mag /= sqrt(2.0);
      x += mag * dx;
      y += mag * dy;
    }
    printf("Map #%d\n", o);
    printf("The treasure is located at (%.3f,%.3f).\n", x, y);
    printf("The distance to the treasure is %.3f.\n\n", sqrt(x*x + y*y));
  }

  return 0;
}
