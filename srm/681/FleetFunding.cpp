#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
#include <map>

using namespace std;

vector<pair<int,int> > V[101010];

class FleetFunding {
public:
  
  int ok(int v,int m) {
    map<int,int> M;
    int i;
    vector<pair<int, int> >::iterator r;
    for(i=1;i<=m;i++) {
      while(M.size() && M.begin()->first<i) M.erase(M.begin());
      for(r = V[i].begin(); r != V[i].end(); r++) M[r->first]+=r->second;
      int d=v;
      while(d>0) {
        if(M.empty()) return 0;
        int s=min(d,M.begin()->second);
        d-=s;
        M.begin()->second-=s;
        if(M.begin()->second==0) M.erase(M.begin());
      }
    }
    return 1;
  }
  
  int maxShips(int m, vector <int> k, vector <int> a, vector <int> b) {
    int i;
    int N=k.size();
    for(i = 0; i < m+2; i++) V[i].clear();
    for(i = 0; i < N; i++) V[a[i]].push_back({b[i],k[i]});
    
    int ret=0;
    for(i=29;i>=0;i--) if(ok(ret+(1<<i),m)) ret+=1<<i;
    return ret;
  }
};
