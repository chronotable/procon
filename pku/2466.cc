#include <stdio.h>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

int main(int argc, char* argv[]){
  int n;
  for(;~scanf("%d", &n);){
    int total = n * (n - 1) / 2;
    vector<int> ps;
    for(int i = 0; i < total; i++){
      int v;
      scanf("%d", &v);
      ps.push_back(v);
    }
    sort(ps.begin(), ps.end());
    bool solved = false;
    for(int i = 2; i < total; i++){
      vector<int> cand;
      int a2 = ps[0] + ps[1] - ps[i];
      if(a2 % 2 == 1)continue;
      int a = a2 / 2;
      cand.push_back(a);
      cand.push_back(ps[0] - a);
      cand.push_back(ps[1] - a);
      bool flag = true;
      map<int, int> m;
      for(int j = 2; j < total; j++)
        if(j != i){
          if(m.count(ps[j]) > 0)
            m[ps[j]]++;
          else
            m.insert(pair<int, int>(ps[j], 1));
        }
      for(int j = 3; j < n; j++){
        int mn = 1<<30;
        for(int k = 2; k < total; k++)
          if(m.count(ps[k]) > 0 && m[ps[k]] > 0){mn = ps[k]; break;}
        m[mn]--;
        int v = mn - a;
        bool found = true;
        for(int k = 1; k < cand.size(); k++){
          int w = v + cand[k];
          if(m.count(w) == 0 || m[w] <= 0){
            found = false;
            break;
          }
          m[w]--;
        }
        if(!found){
          flag = false;
          break;
        }
        cand.push_back(v);
      }
      if(flag){
        printf("%d", cand[0]);
        for(int i = 1; i < n; i++)
          printf(" %d", cand[i]);
        printf("\n");
        solved = true;
        break;
      }
    }
    if(!solved){
      printf("Impossible\n");
    }
  }

  return 0;
}
