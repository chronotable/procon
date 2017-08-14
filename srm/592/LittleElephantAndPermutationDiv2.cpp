#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>

using namespace std;

class LittleElephantAndPermutationDiv2{
public:
  long long getNumber(int N, int K){
    vector<int> a(N);
    long long int p = 1;
    for(int i = 0; i < N; i++){a[i] = i+1; p*=a[i];}
    long long int ret = 0;
    do{
      int sum = 0;
      for(int i = 0; i < N; i++)sum += max(i+1, a[i]);
      if(sum >= K)ret++;
    }while(next_permutation(a.begin(), a.end()));
    return ret * p;
  }
};
