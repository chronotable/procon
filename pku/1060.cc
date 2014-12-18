#include <iostream>
#include <stdio.h>

using namespace std;

void pri(int* a, int n){
  printf("[%d", a[0]);
  for(int i = 1; i < n; i++)printf(" %d", a[i]);
  printf("]\n");
}

int main(){
  int o;
  scanf("%d",&o);
  for(;o;o--){
    int f[1002];
    int g[1002];
    int h[1002];
    int fn, gn, hn;
    int count = 0,v;
    bool flag = false;
    scanf("%d",&fn);
    for(int i = 0; i < fn; i++)scanf("%d",f+i);
    scanf("%d",&gn);
    for(int i = 0; i < gn; i++)scanf("%d",g+i);
    scanf("%d",&hn);
    for(int i = 0; i < hn; i++){
      scanf("%d",&v);
      if(flag)h[count++] = v;
      else if(v>0){
        h[count++] = v;
        flag = true;
      }
    }
    hn = count;
    int p[2002];
    int pn = fn + gn - 1;
    for(int i = 0; i < 2002;i++)p[i]=0;
    for(int i = 0; i < gn; i++){
      if(g[i]==0)continue;
      for(int j = 0; j < fn; j++){
        p[i+j] = (p[i+j] + f[j]) % 2;
      }
    }
    //pri(p, pn);
    for(int i = 0; i <= pn-hn; i++){
      if(p[i] == 0)continue;
      for(int j = 0; j < hn; j++){
        p[i+j] = (p[i+j] + h[j]) % 2;
      }
    }
    count = 0;
    while(p[count] == 0 && count < pn)count++;
    printf("%d", pn-count);
    for(;count < pn; count++)printf(" %d", p[count]);
    printf("\n");
  }

  return 0;
}


