#include <stdio.h>
#define INF 100
int wf[65][65];
int sx[]={2,1,-1,-2,-2,-1,1,2};
int sy[]={1,2,2,1,-1,-2,-2,-1};

int min(int a,int b){return a<b?a:b;}

int id(char* a){
  return (a[0]-'a')*8+a[1]-'1';
}

int main(){
  char from[3],to[3];
  int i,j,k,x,y;
  for(i=0;i<64;i++){
    for(j=0;j<64;j++){
      wf[i][j]=INF;
    }
    wf[i][i]=0;
  }
  for(i=0;i<8;i++){
    for(j=0;j<8;j++){
      for(k=0;k<8;k++){
        y=i+sy[k];
        x=j+sx[k];
        if(y>=0&&y<8&&x>=0&&x<8)wf[i*8+j][y*8+x]=1;
      }
    }
  }
  for(k=0;k<64;k++){
    for(i=0;i<64;i++){
      for(j=0;j<64;j++){
        wf[i][j]=min(wf[i][j],wf[i][k]+wf[k][j]);
      }
    }
  }
  for(;~scanf("%s %s",from,to);){
    printf("To get from %s to %s takes %d knight moves.\n",
            from,to,wf[id(from)][id(to)]);
  }
}

