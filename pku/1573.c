h,w,r,s,u[12][12];char m[12][12];main(i){for(;scanf("%d%d%d",&h,&w,&s),h;memset(u,0,sizeof(u))){for(i=1;i<=h;i++)scanf("%s",m[i]+1);for(i=r=1;r&&r<=h&&s&&s<=w&&!u[r][s];){u[r][s]=i++;if(m[r][s]=='N')r--;else if(m[r][s]=='E')s++;else if(m[r][s]=='S')r++;else if(m[r][s]=='W')s--;}if(u[r][s])printf("%d step(s) before a loop of %d step(s)\n",u[r][s]-1,i-u[r][s]);else printf("%d step(s) to exit\n",i-1);}}
