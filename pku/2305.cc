#include <iostream>
#include <string>
using namespace std;

long long mypow(int a, int b) {
  if(b == 0) return 1;
  if(b % 2) return (long long)a * mypow(a * a, b / 2);
  else      return mypow(a * a, b / 2);
}

int main() {
  int b;
  long long p, m, p10, m10;
  while(cin >> b, b) {
    string pstr;
    cin >> pstr;
    //cout << pstr << endl;
    cin >> m;
    int i = 0;
    int mm = m;
    m10 = 0;
    while(mm > 0) {
      m10 += (mm % 10) * mypow(b, i++);
      mm /= 10;
    }
    //cout << "m10 = " << m10 << endl;
    p = 0;
    int len = pstr.length();
    int ind = 0;
    while(ind < len) {
      while(p < m && ind < len) {
        p = p * 10 + pstr[ind++] - '0';
      }
      //cout << "p = " << p << endl;
      p10 = 0;
      i = 0;
      while(p > 0) {
        p10 += (p % 10) * mypow(b, i++);
        p /= 10;
      }
      //cout << "p10 = " << p10 << endl;
      p10 = p10 % m10;
      //cout << "p10 % m10 = " << p10 << endl;
      i = 1;
      p = 0;
      while(p10 >= b) {
        p += (p10 % b) * i;
        i *= 10;
        p10 /= b;
      }
      p += p10 * i;
    }
    cout << p << endl;
  }
}