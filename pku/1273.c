c[201][201],f[201][201],t[201],q[201],w,n,m,a,i,j,k;min(x,y){return x>y?y:x;}main(){for(;~scanf("%d%d",&n,&m);printf("%d\n",a)){memset(c,0,sizeof(c));memset(f,0,sizeof(f));for(a=i=0;i<n;i++)scanf("%d%d%d",&j,&k,&w),c[j][k]+=w;for(;;){for(i=1;i<=m;i++)t[i]=-1;t[1]=-2;for(q[i=0]=w=1;w-i&&t[m]==-1;){j=q[i++];for(k=1;k<=m;k++)if(t[k]==-1&&c[j][k]>f[j][k]-f[k][j])t[k]=j,q[w++]=k;}if(t[m]==-1)break;for(w=1<<20,i=m,j=t[i];j>0;i=j,j=t[i])w=min(w,c[j][i]-f[j][i]+f[i][j]);for(i=m,j=t[i];j>0;i=j,j=t[i])f[j][i]+=w;a+=w;}}}
