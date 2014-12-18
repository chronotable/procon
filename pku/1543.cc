#include <iostream>
#include <math.h>
#include <stdio.h>
using namespace std;

int main(){
  int n;
  cin >> n;
  for(int i = 2; i <= n; i++){
    int sum = i*i*i;
    for(int j = 2; j < i; j++){
      int su = sum - j*j*j;
      for(int k = j+1; k < i; k++){
        int s = su - k*k*k;
        int l = (int)(pow(1.0 * s, 1.0 / 3.0) + 1e-9);
        if(l > k && s == l*l*l)
          printf("Cube = %d, Triple = (%d,%d,%d)\n", i, j, k, l);
      }
    }
  }
}
