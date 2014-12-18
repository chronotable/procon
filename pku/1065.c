typedef struct p{
  int w,l;
}p;
p stick[5000];
int t,n,u[5000],i,j,k,x,y;

int cmp(const void* a,const void* b){
  p g=*(p*)a,h=*(p*)b;
  if(g.w==h.w)return g.l-h.l;
  else return g.w-h.w;
}

main(){
  for(scanf("%d",&t);t;t--){
    for(scanf("%d",&n),i=0;i<n;i++)scanf("%d%d",&(stick[i].w),&(stick[i].l));
    qsort(stick,n,sizeof(p),cmp);
    memset(u,0,sizeof(u));
    for(k=i=0;i<n;i++){
      if(u[i])continue;
      k++;
      u[i]=1;
      x=stick[i].w;y=stick[i].l;
      for(j=i+1;j<n;j++)if(!u[j]&&x<=stick[j].w&&y<=stick[j].l)u[j]=1,x=stick[j].w,y=stick[j].l;
    }
    printf("%d\n",k);
  }
}

