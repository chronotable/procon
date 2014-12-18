#include <iostream>
#include <vector>
using namespace std;

int i,j,n,k,m,p;
int main(){
  vector<int> u;
  vector<int>::iterator it;
  for(;scanf("%d%d%d",&n,&k,&m),n;u.clear()){
    for(i=1;i<=n;i++)if(i!=m)u.push_back(i);
    m--;
    for(i=1;i<n-1;i++){
      p=n-i;
      if(k%p)p=k%p;
      m=m+p-1;
      m%=(n-i);
      it=u.begin();
      for(j=0;j<m;j++)it++;
      u.erase(it);
    }
    printf("%d\n",u[0]);
  }

  return 0;
}
