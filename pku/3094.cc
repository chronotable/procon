#include<iostream>
using namespace std;
#define M 512

int main() {
  char str[M];
  int val;
  int i;
  while(1) {
    fgets(str, M, stdin);
    //printf("%s\n",str);
    if(str[0] == '#') break;
    val = 0;
    for(i = 0; str[i] != '\n'; i++) {
      if(str[i] == ' ') continue;
      val += (str[i] - 'A' + 1) * (i + 1);
    }
    cout << val << endl;
  }

  return 0;
}
