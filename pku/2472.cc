#include <iostream>
using namespace std;

int main(){
  int n,m,a,b,p,i,j,k;
  double dis[101][101];
  for(;~scanf("%d",&n),n;){
    scanf("%d",&m);
    for(i=0;i<n;i++)for(j=0;j<n;j++)dis[i][j]=0;
    for(i=0;i<m;i++){
      scanf("%d%d%d",&a,&b,&p);a--;b--;
      dis[a][b]=dis[b][a]=p/100.0;
    }
    for(k=0;k<n;k++)for(i=0;i<n;i++)for(j=0;j<n;j++)
    if(dis[i][j]<dis[i][k]*dis[k][j])dis[i][j]=dis[i][k]*dis[k][j];
    printf("%.6lf percent\n",dis[0][n-1]*100.0);
  }
}

