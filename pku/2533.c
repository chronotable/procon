s[1001],l[1001],n,m,t,i,j;main(){for(scanf("%d",&n),m=i=0;i<n;i++){scanf("%d",s+i);for(t=j=0;j<i;j++)if(s[j]<s[i]&&l[j]>t)t=l[j];l[i]=1+t;if(l[i]>m)m=l[i];}printf("%d",m);}
