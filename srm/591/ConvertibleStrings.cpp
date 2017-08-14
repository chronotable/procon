#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class ConvertibleStrings{
public:
  int leastRemovals(string A, string B){
    int n = (int)A.size();
    vector<int> a(9);
    for(int i = 0; i < 9; i++)a[i] = i;
    int ret = n;
    do{
      int sum = 0;
      for(int i = 0; i < n; i++)if(a[A[i]-'A'] != B[i]-'A')sum++;
      ret = min(sum, ret);
    }while(next_permutation(a.begin(), a.end()));
    return ret;
  }
};
