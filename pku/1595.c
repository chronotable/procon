p[999],f[1001],t[1001],n,j,l,r;main(i){for(p[n++]=1,t[1]=1,i=2;i<=1000;t[i]+=t[i-1],i++)if(!f[i])for(p[n++]=i,t[i]++,j=2*i;j<=1000;j+=i)f[j]=1;for(;~scanf("%d%d",&i,&j);printf("\n\n")){printf("%d %d:",i,j);l=t[i]/2-j+t[i]%2;if(l<0)l=0,r=t[i];else r=t[i]/2+j;for(;l<r;l++)printf(" %d",p[l]);}}