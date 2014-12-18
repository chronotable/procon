#include <stdio.h>
#include <stdlib.h>

int main(){
  int n;
  int mat[100][100];
  int i,j;
  int ok;
  int errorx, errory;
  int corrupt;
  int rowsum, colsum;

  for(;;){
    scanf("%d", &n);
    if(!n)break;
    for(i = 0; i < n; i++)
      for(j = 0; j < n; j++)
	scanf("%d", &mat[i][j]);
    ok = 1;
    corrupt = 0;
    errorx = -1; errory = -1;
    for(i = 0; i < n; i++){
      rowsum = colsum = 0;
      for(j = 0; j < n; j++){
	rowsum += mat[i][j];
	colsum += mat[j][i];
      }
      if(rowsum % 2){
	ok = 0;
	if(errory < 0)errory = i + 1;
	else corrupt = 1;
      }
      if(colsum % 2){
	ok = 0;
	if(errorx < 0)errorx = i + 1;
	else corrupt = 1;
      }
    }
    if(ok)printf("OK\n");
    else if(corrupt || errorx < 0 || errory < 0)printf("Corrupt\n");
    else printf("Change bit (%d,%d)\n", errory, errorx);
  }

  return 0;
}