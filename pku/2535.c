q[101],v[101],n,p,i,j,m,h;main(){for(scanf("%d%d",&n,&p),i=0;i<n;i++){for(j=0,m=1001,h=0;j<p;m=m>v[j]?v[j]:m,h=h<v[j]?v[j]:h,j++)scanf("%d",v+j);for(j=0;j<p;j++)v[j]==m?q[j]++:0,(v[j]==h?q[j]=-200:0);}for(j=i=0;i<p;i++)q[i]>n/2?j++:0;j?1:printf("0\n");for(i=0;i<p;i++)q[i]>n/2?printf("%d",i+1),(--j?printf(" "):printf("\n")):0;}