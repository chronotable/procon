#include <iostream>
#include <vector>
using namespace std;

int main() {
  int s,t;
  char c;
  bool f;
  while(scanf("%d", &s) != EOF) {
    vector<int> node;
    t = 0;
    scanf("%c",&c);
    while(c != '(') scanf("%c",&c);
    int level = 1;
    int val = 0;
    f = false;
    bool minus = false, fo = false, fc = false, isleaf = false;
    while(level > 0) {
      scanf("%c",&c);
      if(c >= '0' && c <= '9') {
        val = val * 10 + c - '0';
        fc = false;
        isleaf = false;
      }else if(c == '(') {
        if(minus) val = -val;
        minus = false;
        node.push_back(val);
        level++;
        t += val;
        val = 0;
        fo = true;
        if(fc) {
          isleaf = true;
          fc = false;
        }
      }else if(c == ')'){
        if(t == s && isleaf) f = true;
        isleaf = false;
        if(fo) {
          fc = true;
          fo = false;
        }else {
          fc = false;
        }
        //printf("t = %d\n",t);
        if(level > 1) {
          val = node[level - 2];
          node.pop_back();
          t -= val;
        }
        level--;
        fo = false;
      }else if(c == '-') {
        minus = true;
      }
      //printf("%c",c);
    }
    if(f) printf("yes\n");
    else       printf("no\n");
  }
  return 0;
}