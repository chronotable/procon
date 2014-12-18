#include<iostream>

using namespace std;

int main() {
  int m,n;
  int a[10001];
  int b;
  int fi,se;
  while(cin >> m >> n,m+n) {
    fi = 0;
    se = 0;
    memset(a,0,sizeof(int) * 10001);
    //fill(a,a + 10001,0);
    for(int i = 0;i < m * n;i++) {
      scanf("%d",&b);
      a[b]++;
      /*
      if(a[b] > fi) {
        se = fi;
        fi = a[b];
      }else if(a[b] > se) {
        se = a[b];
      }
      */
    }
    for(int i = 0;i < 10001;i++) {
      if(a[i] > fi) {
        se = fi;
        fi = a[i];
      }else if(a[i] > se) {
        se = a[i];
      }
    }
    for(int i = 1; i < 10001; i++) {
      if(a[i] == se) printf("%d ",i);
    }
    printf("\n");
  }
}