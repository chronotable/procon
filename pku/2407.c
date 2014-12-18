#include <stdio.h>
main(){
  int input,i;
  double save;
  scanf("%d",&input);
  while(input!=0){
    if(input==1)printf("0\n");
    else {
      save=input;
      if(input%2==0)save/=2;
      while(input%2==0)input/=2;
      for(i=3;input!=1;i=i+2){
	if(input%i==0)save=save*(i-1)/i;
	while(input%i==0)input/=i;
      }
      printf("%.0lf\n",save);
    }
    scanf("%d",&input);
  }
}

