#include <stdio.h>
#include <math.h>

int main(){
  int i,j,k,n,m,ind;
  double x[1001], y[1001];
  double dis[1001][1001],ans,mn;
  scanf("%d%d",&n,&m);
  for(i = 0; i < n; i++)scanf("%lf%lf",x+i,y+i);
  for(i = 0; i < n;i++){
    for(j = 0; j < n;j++){
      dis[i][j] = dis[j][i] = sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
    }
  }
  for(i = 0; i < m;i++){
    scanf("%d%d",&j,&k);
    j--;k--;
    dis[j][k] = dis[k][j] = 0;
  }
  ans = 0;
  for(k = 1; k < n;k++){
    mn = 1e40;
    ind = 0;
    for(i = 1; i < n;i++){
      if(dis[0][i] < 0)continue;
      if(mn > dis[0][i]){
        mn = dis[0][i];
        ind = i;
      }
    }
    if(mn >= 1e40)break;
    ans += mn;
    for(j = 1; j < n;j++)if(dis[0][j]>dis[ind][j])dis[0][j]=dis[ind][j];
    dis[0][ind] = -100.0;
  }
  printf("%.2lf\n", ans);
}
