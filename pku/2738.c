#include <stdio.h>
#define MAX 1000
int dp[MAX][MAX],n,i,seq[MAX],ans;

int tra(int s,int e){
  if(dp[s][e])return dp[s][e];
  if(s>=e)return 0;
  int l,r;
  l=seq[s];
  if(seq[s+1]<seq[e])l+=tra(s+1,e-1);
  else l+=tra(s+2,e);
  r=seq[e];
  if(seq[s]<seq[e-1])r+=tra(s,e-2);
  else r+=tra(s+1,e-1);
  dp[s][e]=l>r?l:r;
  return dp[s][e];
}

int main(){
  int sum,g=1;
  for(;scanf("%d",&n),n;g++){
    memset(dp,0,sizeof(dp));
    for(sum=i=0;i<n;i++)scanf("%d",seq+i),sum+=seq[i];
    ans=tra(0,n-1);
    printf("In game %d, the greedy strategy might lose by as many as %d points.\n",
            g,ans-(sum-ans));
  }
}
