#include<iostream>
#define N (80)

using namespace std;

void add(int* a,int* b) {
  int i,c = 0;
  for(i = 0;i < N;i++) {
    a[i] += b[i] + c;
    if(a[i] > 9) {
      a[i] -= 10;
      c = 1;
    }else {
      c = 0;
    }
  }
}

void multi(int* a,int* b) {
  int i,c = 0;
  for(i = 0;i < N;i++) {
    a[i] = b[i] * 2 + c;
    if(a[i] > 9) {
      a[i] -= 10;
      c = 1;
    }else {
      c = 0;
    }
  }
}

int main() {
  int n;
  //int mae;
  int s,c,i;
  int flag;
  int** a;

  //mae = 300;
  while(cin >> n) {
    //if(n == pren) break;

    if(n < 2) {
      cout << 1 << endl;
      continue;
    }

    a = (int**)malloc(n * sizeof(int*));
    for(i = 0;i < n;i++) a[i] = (int *)calloc(N,sizeof(int));
    a[0][0] = 1;
    a[1][0] = 2;
    //cout << "koko" << endl;
    for(i = 0;i < n - 1;i++) {
      add(a[i + 1],a[i]);
      if(i + 2 < n) multi(a[i + 2],a[i]);
    }

    flag = 0;
    for(i = N - 1;i >= 0;i--) {
      if(flag) {
        cout << a[n - 1][i];
      }else {
        if(a[n - 1][i] != 0) {
          flag = 1;
          cout << a[n - 1][i];
        }
      }
    }
    cout << endl;
    for(i = 0;i < n;i++) free(a[i]);
    //cout << "end" << n << endl;
    //pren = n;
  }
  return -1;
}