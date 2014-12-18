#include <iostream>
#include <vector>
using namespace std;
#define MAX 1000000
int main() {
  bool is_prime[MAX + 1];
  vector <int> primes;
  fill(is_prime + 1, is_prime + MAX + 1, true);
  primes.push_back(2);
  for(int i = 4; i <= MAX; i += 2) is_prime[i] = false;
  for(int i = 3; i <= MAX; i += 2) {
    if(is_prime[i]) {
      for(int j = i * 2; j <= MAX; j += i) is_prime[j] = false;
      primes.push_back(i);
    }
  }
  int n;
  while(cin >> n, n) {
    for(int i = 0; i < primes.size(); i++) {
      if(n / 2 < primes[i]) {
        cout << "Goldbach's conjecture is wrong." << endl;
        break;
      }
      if(is_prime[n - primes[i]]) {
        cout << n << " = " << primes[i] << " + " << n - primes[i] << endl;
        break;
      }
    }
  }
  return 0;
}