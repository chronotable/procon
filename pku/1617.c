#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, char* argv[]){
  char keyword[20];
  char cipher[200];
  char f[200][20];
  int w,h,i,j;
  int seq[20];
  int count;
  char c;
  
  for(;;){
    scanf("%s", keyword);
    if(strcmp(keyword, "THEEND") == 0)break;
    scanf("%s", cipher);
    w = strlen(keyword);
    h = strlen(cipher) / w;
    //printf("w = %d, h = %d\n", w, h);
    count = 0;
    for(i = 0; i < 26 ; i++){
      c = 'A' + i;
      for(j = 0; j < w; j++)if(keyword[j] == c)seq[count++] = j;
    }
    count = 0;
    for(i = 0; i < w; i++){
      for(j = 0; j < h; j++)f[j][seq[i]] = cipher[count++];
    }
    for(i = 0; i < h; i++)f[i][w] = '\0';
    for(i = 0; i < h; i++)printf("%s", f[i]);
    printf("\n");
  }
  
  return 0;
}
