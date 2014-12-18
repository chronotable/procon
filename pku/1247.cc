#include <iostream>
#include <stdio.h>

using namespace std;

int main(){
  int n;
  int s[40];
  while(1){
    cin >> n;
    if(!n)break;
    int sum = 0;
    for(int i = 0; i < n; i++){
      cin >> s[i];
      sum += s[i];
    }
    int t = 0;
    int i;
    for(i = 0; i < n; i++){
      t += s[i];
      if(t == sum - t)break;
    }
    if(i == n)
      cout << "No equal partitioning." << endl;
    else
      printf("Sam stops at position %d and Ella stops at position %d.\n",
	     i+1, i+2);
  }

  return 0;
}