typedef struct p{int d,c;}p;p t[10001];a,m,n,i;f(const void* a,const void* b){return ((*(p*)a).d-(*(p*)b).d)*99999+(*(p*)a).c-(*(p*)b).c;}main(){for(;scanf("%d",&n),n;printf("%d\n",a)){for(i=0;i<n;i++)scanf("%d%d",&(t[i].d),&(t[i].c));qsort(t,n,sizeof(p),f);for(m=20000,a=i=0;i<n;i++)if(m>t[i].c)a++,m=t[i].c;}}
