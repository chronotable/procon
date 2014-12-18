#define M 1300000
p[100001],u[M],d[M],n,k,i,j,a;main(){for(i=2;n<=100000;i++){if(!u[i]){for(j=i*2;j<M;j+=i)u[j]=1;p[n]=i;d[i]=n++;}}for(;scanf("%d",&k),k;a=0){if(u[k]){for(;u[--k];);a=p[d[k]+1]-k;}printf("%d\n",a);}}
