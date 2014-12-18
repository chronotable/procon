#include <iostream>
#include <stdio.h>

using namespace std;

int main(){
  int n;

  for(;;){
    cin >> n;
    if(n==0)break;
    int ans = -1;
    for(int i = 0;; i++){
      int cube = i*i*i;
      if(cube > n)break;
      int rest = n - cube;
      if(n - ans > rest)ans = cube;
      for(int j = 1;;j++){
	int tet = j * (j+1) * (j+2) / 6;
	if(tet > rest)break;
	if(n - ans > rest - tet)ans = cube + tet;
      }
    }
    cout << ans << endl;
  }

  return 0;
}
