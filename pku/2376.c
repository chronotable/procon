typedef struct span{int s,e;}span;int cmp(const void* a,const void* b){return ((span*)a)->s-((span*)b)->s;}span s[25010];ans,n,N,T,a,b,i;main(j){scanf("%d%d",&N,&T);for(i=0;i<N;i++){scanf("%d%d",&a,&b);s[n].s=a;s[n++].e=b;}qsort(s,n,sizeof(span),cmp);for(a=b=i=0;b!=T&&i<n&&j;ans++,b=a)for(j=0;i<n&&s[i].s<=b+1;i++,j++)if(b<s[i].e&&a<s[i].e)a=s[i].e;printf("%d\n",b==T?ans:-1);}