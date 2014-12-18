#include <iostream>
#include <list>
#include <algorithm>
using namespace std;

int w,h;

class Floor {
public:
  int p[12][12];
  Floor() {
    for(int i = 0; i < 12; i++) {
      for(int j = 0; j < 12; j++) {
        p[i][j] = 0;
      }
    }
  }

  int subtract(Floor &f) {
    int flag = 0;
    for(int i = 1; i <= h; i++) {
      for(int j = 1; j <= w; j++) {
        if(f.p[i][j] != 0) p[i][j] = 0;
        else if(p[i][j] != 0) flag = 1;
      }
    }
    return flag;
  }

  int contains(Floor &f) {
    for(int i = 1; i <= h; i++) {
      for(int j = 1; j <= w; j++) {
        if(p[i][j] == 0 && f.p[i][j] != 0) return 0;
      }
    }
    return 1;
  }
};
typedef list<Floor> FloorList;

void optimize(FloorList & lst) {
  FloorList::iterator i, j;
  for(i = lst.begin(); i != lst.end();) {
    for(j = lst.begin(); j != lst.end(); j++) {
      if(i == j) continue;
      if(j->contains(*i)) break;
    }
    if(j != lst.end()) {
      i = lst.erase(i);
    }else {
      i++;
    }
  }
}

int searchall(FloorList lst, Floor flr) {
  if(lst.empty()) return 100;
  Floor cpt = lst.back();
  lst.pop_back();
  int c1, c2;
  c1 = searchall(lst, flr);
  if(flr.subtract(cpt) == 0) return 1;
  c2 = searchall(lst, flr) + 1;
  return min(c1, c2);
}

int main() {
  while(true) {
    cin >> w >> h;
    if(w == 0 && h == 0) break;
    Floor flr;
    FloorList cptlst;
    for(int i = 1; i <= h; i++) {
      for(int j = 1; j <= w; j++) {
        cin >> flr.p[i][j];
      }
    }

    for(int i = 1; i <= h; i++) {
      for(int j = 1; j <= w; j++) {
        if(flr.p[i][j] == 0) continue;
        int n, k;
        for(n = 1;; n++) {
          for(k = 0; k <= n; k++) {
            if(flr.p[i + n][j + k] == 0 || flr.p[i + k][j + n] == 0) break;
          }
          if(k != n + 1) break;
        }
        Floor cpt;
        for(int s = 0; s < n; s++) {
          for(int t = 0; t < n; t++) {
            cpt.p[i + s][j + t] = 1;
          }
        }
        cptlst.push_back(cpt);
      }
    }

    optimize(cptlst);
    int count = 0;
    while(cptlst.size() != 0) {
      Floor dup;
      FloorList::iterator i;
      int flag = 0;
      for(i = cptlst.begin(); i != cptlst.end(); i++) {
        for(int j = 1; j <= h; j++) {
          for(int k = 1; k <= w; k++) {
            dup.p[j][k] += i->p[j][k];
          }
        }
      }

      for(int j = 1; j <= h; j++) {
        for(int k = 1; k <= w; k++) {
          if(flr.p[j][k] == 0 || dup.p[j][k] != 1) continue;
          for(i = cptlst.begin(); i != cptlst.end(); i++) {
            if(i->p[j][k] != 0) break;
          }
          if(i == cptlst.end()) continue;
          count++;
          flag = 1;
          Floor tmpcpt = *i;
          cptlst.erase(i);
          flr.subtract(tmpcpt);

          for(i = cptlst.begin(); i != cptlst.end();) {
            if(i->subtract(tmpcpt) == 0) {
              i = cptlst.erase(i);
            }else {
              i++;
            }
          }
          optimize(cptlst);

        }
      }

      if(flag == 0) {
        count += searchall(cptlst, flr);
        break;
      }

    }
    cout << count << endl;

  }
}