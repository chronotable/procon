c[10],s[1001],n,j,x,t[1001],f;main(i){for(;i=getchar(),i-'-';){s[0]=i-'0';for(n=1;(i=getchar())!='\n';)s[n++]=i-'0';memset(c,0,sizeof(c));if(n==1){printf("1%d\n",s[0]);continue;}for(;!(n==1&&s[0]==1);){for(i=9;i>1;i--){f=0;if(s[0]<i)x=s[0];else t[f++]=s[0]/i,x=s[0]%i;for(j=1;j<n;j++){x=x*10+s[j];t[f++]=x/i;x=x%i;}if(!x)break;}if(i<2)break;c[i]++;for(i=0;i<f;i++)s[i]=t[i];n=f;}if(n==1&&s[0]==1) for(i=1;i<10;i++)for(j=0;j<c[i];j++)printf("%d",i);else printf("There is no such number.");puts("");}}
