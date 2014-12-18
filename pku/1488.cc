#include <iostream>
#include <stdio.h>

using namespace std;

int main(){

  char line[1024];
  bool first = true;

  while(cin.getline(line, 1024)){
    for(int i = 0; line[i]; i++){
      if(line[i] == '\"'){
        if(first)printf("``");
        else printf("''");
        first = !first;
      }else{
        printf("%c", line[i]);
      }
    }
    printf("\n");
  }

  return 0;
}
