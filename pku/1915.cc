#include <iostream>
#include <vector>
using namespace std;
struct pos{
  int x,y;
};
bool v[301][301];
vector<pos> tbl;
int n,l,step[8][2]={2,1,1,2,-1,2,-2,1,-2,-1,-1,-2,1,-2,2,-1};
bool move(int gx,int gy,int &i){
  int s=tbl.size();
  for(;i<s;i++){
    pos p;
    if(tbl[i].x==gx&&tbl[i].y==gy)return true;
    for(int j=0;j<8;j++){
      p.x=tbl[i].x+step[j][0];
      p.y=tbl[i].y+step[j][1];
      if(p.x>=l||p.x<0||p.y>l||p.y<0||v[p.x][p.y])continue;
      v[p.x][p.y]=true;
      tbl.push_back(p);
    }
  }
  return false;
}

int main(){
  int sx,sy,dx,dy;
  for(cin>>n;n>0;n--){
    cin>>l>>sx>>sy>>dx>>dy;
    for(int a=0;a<l;a++)for(int b=0;b<l;b++)v[a][b]=false;
    pos st;
    st.x=sx;st.y=sy;
    v[sx][sy]=true;
    tbl.clear();
    tbl.push_back(st);
    int ans=-1,ind=0;
    bool f=false;
    while(!f){
      f=move(dx,dy,ind);
      ans++;
    }
    cout<<ans<<endl;
  }
}