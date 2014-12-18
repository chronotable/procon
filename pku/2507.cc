#include <iostream>
#include <math.h>
#include <stdio.h>
//#include <iomanip.h>
using namespace std;

double calc(double x, double y, double z){
  return sqrt(x*x-z*z) * sqrt(y*y-z*z) / (sqrt(x*x-z*z) + sqrt(y*y-z*z));
}

int main(){
  double x,y,c;
  while(cin >> x >> y >> c){
    double l = 0, r,m;
    if(x > y)r = y;
    else r = x;
    for(int i = 0; i < 2000; i++){
      m = (l+r) / 2;
      double v = calc(x, y, m);
      if(v > c){
        l = m;
      }else{
        r = m;
      }
    }
    printf("%.3f\n", r);
    //cout << setiosflags(ios::fixed) << setprecision(3) << m << endl;
  }

  return 0;
}
