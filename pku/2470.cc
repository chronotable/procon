#include <stdio.h>

using namespace std;

int main(){

  int n;
  int s[100001];
  int t[100001];

  for(;;){
    scanf("%d",&n);
    if(n==0)break;
    for(int i = 0; i < n; i++){
      scanf("%d",s+i);
      t[--s[i]] = i;
    }
    int j = 0;
    for(;j < n; j++)if(s[j] != t[j])break;
    if(j==n)printf("ambiguous\n");
    else printf("not ambiguous\n");
  }

  return 0;
}
