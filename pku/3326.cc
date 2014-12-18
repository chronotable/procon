#include <iostream>
#include <vector>
using namespace std;
int rec[1001][10001];

class Span {
public:
  int logi;
  int logo;
};

vector<Span> spans[10001];

void add_span(vector<Span> &v, Span &s) {
  vector<Span>::iterator it = v.begin();
  for(;it != v.end();it++) {
    if(s.logi < it->logi) break;
  }
  v.insert(it,s);
  for(it = v.begin() + 1;it != v.end();it++) {
    if((it-1)->logo >= it->logi) {
      if((it-1)->logo >= it->logo) {
        v.erase(it);it--;
      }else {
        (it-1)->logo = it->logo;
        v.erase(it);it--;
      }
    }
  }
}

int main() {
  int i,j,N,M,r,q;
  int t,n,m,s,ts,te;
  for(;cin >> N >> M,N+M > 0;) {
    for(i = 0; i <= N;i++) {
      for(j = 0; j <= M; j++)
        rec[i][j] = 0;
    }
    for(i = 0;i <= M;i++) spans[i].clear();
    for(cin >> r;r > 0;r--) {
      cin >> t >> n >> m >> s;
      if(s == 1) {
        rec[n][m] = t;
      }else {
        Span sp;
        sp.logi = rec[n][m];
        sp.logo = t;
        rec[n][m] = 0;
        add_span(spans[m],sp);
      }
    }
    for(cin >> q;q > 0;q--) {
      cin >> ts >> te >> m;
      t = 0;
      vector<Span>::iterator it;
      for(it = spans[m].begin();it != spans[m].end();it++) {
        if(it->logi > te) break;
        if(it->logo < ts) continue;
        if(it->logi < ts) {
          if(it->logo < te) {
            t += it->logo - ts;
          }else {
            t += te - ts;
          }
        }else {
          if(it->logo < te) {
            t += it->logo - it->logi;
          }else {
            t += te - it->logi;
          }
        }
      }
      cout << t << endl;
    }
  }

  return 0;
}