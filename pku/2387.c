typedef struct st{
  int p,t;
}st;
st tbl[50000];
int path[1001][1001],mv[1001],T,N,n,s;
main(){
  int i,j,k,v,l;
  scanf("%d%d",&T,&N);
  for(i=0;i<T;i++){
    scanf("%d%d%d",&j,&k,&l);
    if(path[j][k] !=0){
      if(path[j][k]>l) path[j][k]=path[k][j]=l;
    }else{
      path[j][k]=path[k][j]=l;
    }
  }
  for(i=0;i<1001;i++)mv[i]=100000000;
  tbl[n].p=N;tbl[n++].t=0;
  while(tbl[s].p!=1){
    for(i=1;i<=N;i++){
      if(path[tbl[s].p][i]){
        v=tbl[s].t+path[tbl[s].p][i];
        if(mv[i] <= v)continue;
        mv[i]=v;
        for(j=s+1;j<n;j++)if(tbl[j].t>v)break;
        for(k=n;k>j;k--)tbl[k]=tbl[k-1];
        tbl[j].p=i;tbl[j].t=v;
        n++;
      }
    }
    s++;
  }
  printf("%d\n",tbl[s].t);
}