#include <iostream>
#include <math.h>
#define min(a,b) (a<b?a:b)
#define max(a,b) (a>b?a:b)
using namespace std;

int main(){
  int n,i,j,k,o;
  double dis[201][201];
  int x[201];
  int y[201];
  for(o=1;;o++){
    scanf("%d",&n);
    if(n==0)break;
    for(i=0;i<n;i++)scanf("%d%d",x+i, y+i);
    for(i=0;i<n;i++)for(j=0;j<n;j++)
      dis[i][j]=sqrt(1.0*(x[i]-x[j])*(x[i]-x[j]) + 1.0*(y[i]-y[j])*(y[i]-y[j]));
    for(i=0;i<n;i++)dis[i][i] = 1e30;
    for(k=0;k<n;k++)
      for(i=0;i<n;i++)for(j=0;j<n;j++)if(i!=j)dis[i][j]=min(dis[i][j],max(dis[i][k],dis[k][j]));
    printf("Scenario #%d\n",o);
    printf("Frog Distance = %.3lf\n\n",dis[0][1]);
  }

  return 0;
}
