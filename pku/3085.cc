#include <iostream>
#include <stdio.h>

int main(int argc, char* argv[]){
  int n;
  scanf("%d", &n);
  for(int o = 1; o <= n; o++){
    int v;
    scanf("%d", &v);
    int qua = v / 25;
    v -= qua * 25;
    int dim = v / 10;
    v -= dim * 10;
    int nic = v / 5;
    v -= nic * 5;
    int pen = v;
    printf("%d %d QUARTER(S), %d DIME(S), %d NICKEL(S), %d PENNY(S)\n",
           o, qua, dim, nic, pen);
  }

  return 0;
}