#define M 1441

typedef struct state{
  int min;
  int car;
  int trip;
}state;

int cmp(const void* a, const void* b) {
  return ((state*)a)->min - ((state*)b)->min;
}

int arrive[M];
state tbl[1000000];
int num;

main() {
  int i,j,k,l,a,n,t,m,c,start;
  for(scanf("%d",&a);a > 0;a--) {
    scanf("%d%d%d",&n,&t,&m);
    for(i = 0;i < m;i++) scanf("%d",arrive+i);
    num = 0;
    for(i = 0; i < n && i < m;i++) {
      tbl[num].min = arrive[i] + 2*t;
      tbl[num].car = i+1;
      tbl[num++].trip = 1;
    }
    qsort(tbl,num,sizeof(state),cmp);
    for(i = 0;i < num;i++) {
      if(tbl[i].car >= m) break;
      for(c=0;c+tbl[i].car < m && arrive[c+tbl[i].car] < tbl[i].min;c++);
      if(c > n-1) c=n-1;
      for(j = c;j < n && tbl[i].car + j < m;j++) {
        if(arrive[tbl[i].car + j] > tbl[i].min) start = arrive[tbl[i].car + j];
        else start = tbl[i].min;

        for(k = num;k > 0;k--) if(start + t * 2 > tbl[k - 1].min) break;
        for(l = num;l > k;l--) tbl[l] = tbl[l - 1];
        tbl[k].min = start + t * 2;
        tbl[k].car = tbl[i].car + j + 1;
        tbl[k].trip = tbl[i].trip + 1;
        num++;
      }
    }
    for(j = 1; j + i < num; j++) {
      if(tbl[i + j].min != tbl[i].min) break;
      if(tbl[i + j].car == tbl[i].car && tbl[i + j].trip < tbl[i].trip) {
        i += j;
        j = 0;
      }
    }
    printf("%d %d\n",tbl[i].min - t, tbl[i].trip);
  }
}