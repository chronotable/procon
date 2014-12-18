#include <iostream>
#include <queue>
using namespace std;

struct node{
  int p,t;
  node(int p,int t):p(p),t(t){}
  bool operator<(const node& n) const {
    return t > n.t;
  }
};

int n,m,x,an[1001],con[1001][1001],cl[1001][1001];

main(){
  int i,j,r,s,t;
  int ans=-1;
  scanf("%d%d%d",&n,&m,&x);
  memset(an,0,sizeof(an));
  memset(con,0,sizeof(con));
  memset(cl,0,sizeof(cl));
  for(i=0;i<m;i++){
    scanf("%d%d%d",&r,&s,&t);
    cl[r][an[r]++]=s;
    con[r][s]=t;
  }

  for(i=1;i<=n;i++){

    int tbl[1001],total;
    memset(tbl,1,sizeof(tbl));
    tbl[i]=0;
    priority_queue<node> pq;
    node st(i,0);
    pq.push(st);
    while(!pq.empty()){
      node n = pq.top();
      pq.pop();
      tbl[n.p]=n.t;
      if(n.p == x){
        total = n.t;
        break;
      }
      for(j = 0;j < an[n.p];j++){
        int nx = cl[n.p][j];
        if(tbl[nx]>n.t+con[n.p][nx])pq.push(node(nx,n.t+con[n.p][nx]));
      }
    }
    /*for home*/
    memset(tbl,1,sizeof(tbl));
    priority_queue<node> pp;
    pp.push(node(x,total));
    while(!pp.empty()){
      node n = pp.top();
      pp.pop();
      tbl[n.p]=n.t;
      if(n.p == i){
        total = n.t;
        break;
      }
      for(j = 0;j < an[n.p];j++){
        int nx = cl[n.p][j];
        if(tbl[nx]>n.t+con[n.p][nx])pp.push(node(nx,n.t+con[n.p][nx]));
      }
    }
    if(total>ans)ans=total;
  }
  printf("%d",ans);

}
