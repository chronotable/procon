#include <iostream>
using namespace std;

int cnt[100001];
bool f[100001];
typedef struct C{
  int val, num;
}C;

C coin[101];
int main(){
  int n,m;
  int i,j,k,ans;
  while(true){
    scanf("%d%d", &n, &m);
    if(n+m==0)break;
    for(i=0;i<n;i++)scanf("%d",&coin[i].val);
    for(i=0;i<n;i++)scanf("%d",&coin[i].num);
    for(i=1;i<=m;i++)f[i]=false;
    f[0]=true;
    ans=0;
    for(i=0;i<n;i++){
      for(j=0;j<=m;j++)cnt[j]=0;
      for(j=coin[i].val;j <= m;j++){
	if(!f[j] && f[j-coin[i].val] && cnt[j-coin[i].val] < coin[i].num){
	  f[j] = true;
	  ans++;
	  cnt[j] = cnt[j-coin[i].val] + 1;
	}
      }
    }
    printf("%d\n",ans);
  }
}
