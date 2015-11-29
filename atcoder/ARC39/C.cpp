#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <iostream>
#include <cmath>
#include <algorithm>

#include <string>
#include <vector>
#include <deque>
#include <queue>
#include <set>
#include <map>

using namespace std;

typedef long long ll;
typedef pair<int, int> pii;

class Link{
public:
  int x, y;
  pair<int, int> left, right, up, down;
  Link(){}
  Link(int _x, int _y): x(_x), y(_y), left(_x-1, _y), right(_x+1, _y), up(_x, _y+1), down(_x, _y-1){}
  void print(){
    printf("(%d, %d)\n", x, y);
  }
};

int K;
char s[200100];
const int dx[] = {1, 0, -1, 0};
const int dy[] = {0, 1, 0, -1};
const string D = "RULD";
map< pair<int, int>, Link > ls;

void update(pii cur, char d, pii next){
  if(ls.find(cur) == ls.end())
    ls[cur] = Link(cur.first, cur.second);
  Link& cell = ls[cur];
  switch(d){
  case 'R':
    cell.right = next;
    break;
  case 'L':
    cell.left = next;
    break;
  case 'U':
    cell.up = next;
    break;
  case 'D':
    cell.down = next;
    break;
  }
}

Link visit(pii p){
  int x = p.first, y = p.second;
  pii vl(x, y);
  Link cell = ls[vl];
  //pii l(x-1, y), r(x+1, y), u(x, y+1), d(x, y-1);
  update(cell.left, 'R', cell.right);
  update(cell.right, 'L', cell.left);
  update(cell.up, 'D', cell.down);
  update(cell.down, 'U', cell.up);
  return cell;
}

int main(){
  scanf("%d%s", &K, s);
  ls.clear();
  ls[make_pair(0, 0)] = Link(0, 0);
  Link cur = visit(make_pair(0, 0));
  for(int i = 0; i < K; i++){
    char d = s[i];
    switch(d){
    case 'R':
      cur = visit(cur.right);
      break;
    case 'L':
      cur = visit(cur.left);
      break;
    case 'U':
      cur = visit(cur.up);
      break;
    case 'D':
      cur = visit(cur.down);
      break;
    }
    //cur.print();
  }
  printf("%d %d\n", cur.x, cur.y);

  return 0;
}
