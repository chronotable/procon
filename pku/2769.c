t[301],u[30000],g,a,i,j;main(){for(scanf("%d",&g);~scanf("%d",&g);printf("%d\n",a)){for(j=0;j<g;j++)scanf("%d",t+j);for(a=g;;a++){for(i=0;i<a;u[i++]=0);for(i=0;i<g;i++){if(u[j=t[i]%a])break;else u[j]=1;}if(i==g)break;}}}