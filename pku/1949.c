u[10001],n,a,t,j,k,m;main(i){for(scanf("%d",&n);i<=n;i++){scanf("%d",&t);for(scanf("%d",&j),m=0;j;j--)scanf("%d",&k),m=u[k]>m?u[k]:m;u[i]=m+t;a=u[i]>a?u[i]:a;}printf("%d",a);}
