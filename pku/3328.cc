#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int w, h;

struct Node {
  int x;
  int y;
  int c;
  int next_left;

  Node(int x, int y, int c, int f) : x(x), y(y), c(c), next_left(f) {}

  bool operator<(const Node& t) const {
    return c > t.c;
  }
};

int traverse(vector<vector<char> >& cliff) {
  priority_queue<Node> pq;
  vector<vector<vector<int> > > len(h, vector<vector<int> > (w, vector<int>(2, -1)));
  int i,j;
  int nx,ny;

  for(i = 0; i < h; i++) {
    for(int j = 0; j < w; j++) {
      if(cliff[i][j] == 'S') {
        pq.push(Node(j, i, 0, 0));
        pq.push(Node(j, i, 0, 1));
      }
    }
  }

  while(!pq.empty()) {
    Node node = pq.top();
    pq.pop();

    if(len[node.y][node.x][node.next_left] != -1) continue;
    if(cliff[node.y][node.x] == 'T') return node.c - ('T' - '0');

    len[node.y][node.x][node.next_left] = node.c;
    //node.next_left = !node.next_left;

    for(i = 1; i <= 3; i++) {
      nx = (node.next_left) ? node.x + i : node.x - i;
      for(j = -2; j <= 2; j++) {
        ny = node.y + j;
        if(!(nx >= 0 && nx < w && ny >= 0 && ny < h)) continue;
        if(len[ny][nx][!node.next_left] == -1 && cliff[ny][nx] != 'X') {
          if(abs(node.x - nx) + abs(node.y - ny) <= 3) {
            pq.push(Node(nx, ny, node.c + cliff[ny][nx] - '0', !node.next_left));
          }
        }
      }
    }
  }

  return -1;

}

int main() {
  int i,j;
  while(cin >> w >> h, w + h) {
    vector<vector<char> > cliff(h, vector<char>(w));
    for(i = 0; i < h; i++)
      for(j = 0; j < w; j++) cin >> cliff[i][j];

    cout << traverse(cliff) << endl;
  }
}