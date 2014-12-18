#include <stdio.h>
#include <stdlib.h>

int main(){
  int n,s;
  int i,j;
  int t[21][21];
  scanf("%d%d", &n, &s);

  for(i = 0; i < n; i++){
    for(j = 0; j < i+1; j++){
      t[j][i] = s % 10;
      s++;
      if(s % 10 == 0)s++;
    }
  }

  for(i = 0; i < n; i++){
    for(j = 0; j < i; j++)printf("  ");
    for(j = i; j < n-1; j++)printf("%d ", t[i][j]);
    printf("%d\n", t[i][j]);
  }

  return 0;
}
