#include <iostream>
#include <set>
#include <algorithm>
using namespace std;

int main(){
  for(;;){
    int gn,ln,n;
    scanf("%d%d%d",&gn,&ln,&n);
    if(gn+ln+n==0)break;
    int fir[gn+ln];
    for(int i = 0; i < gn+ln;i++)scanf("%d",fir+i);
    sort(fir,fir+(gn+ln));
    multiset<int> lms;
    multiset<int> gms;
    for(int i = 0; i < ln;i++){
      lms.insert(fir[i]);
    }
    for(int i = ln; i < ln+gn;i++)gms.insert(fir[i]);
    multiset<int>::iterator git;
    multiset<int>::reverse_iterator lit;
    int v;
    long long sum = 0;
    for(int i = gn+ln; i < n;i++){
      scanf("%d",&v);
      lit = lms.rbegin();
      git = gms.begin();
      if(v < *lit){
	sum += *lit;
	lms.erase(lms.find(*lit));
	lms.insert(v);
      }else if(v > *git){
	sum += *git;
	gms.erase(git);
	gms.insert(v);
      }else{
	sum += v;
      }
    }
    printf("%.6lf\n",(double)sum / (n-gn-ln));
  }

  return 0;
}