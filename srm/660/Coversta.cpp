#include <stdio.h>

#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

class Coversta{
public:
  int h, w, n;
  vector<int> X, Y;
  vector<string> a;
  inline bool in(int x, int y){
    return x >= 0 && x < w && y >= 0 && y < h;
  }
      int calc(int x1, int y1, int x2, int y2){
      int ret = 0;
      vector< pair<int, int> > s;
      for(int i = 0; i < n; i++)s.push_back(make_pair(x1 + Y[i], y1 + X[i]));
      for(int i = 0; i < n; i++)s.push_back(make_pair(x2 + Y[i], y2 + X[i]));
      sort(s.begin(), s.end());
      s.erase(unique(s.begin(), s.end()), s.end());
      for(size_t i = 0; i < s.size(); i++){
        int x = s[i].first;
        int y = s[i].second;
        if(!in(x, y))continue;
        ret += a[y][x] - '0';
      }
      return ret;
    }
    int place(vector<string> a, vector<int> X, vector<int> Y){
      this->X = X;
      this->Y = Y;
      this->a = a;
      h = a.size(), w = a[0].size();
      n = X.size();
      vector< pair<int, pair<int, int> > > ss;
      for(int y = 0; y < h; y++)for(int x = 0; x < w; x++){
          int sum = 0;
          for(int i = 0; i < n; i++){
            int cy = y + X[i], cx = x + Y[i];
            if(in(cx, cy))sum += a[cy][cx] - '0';
          }
          ss.push_back(make_pair(-sum, make_pair(x, y)));
        }
      sort(ss.begin(), ss.end());
      if(ss.size() > 1000)ss.resize(1000);
      int ans = 0;
      for(int i = 0; i < ss.size(); i++)for(int j = 0; j < i; j++)
                                          ans = max(ans, calc(ss[i].second.first, ss[i].second.second, ss[j].second.first, ss[j].second.second));
      return ans;
    }
  };
