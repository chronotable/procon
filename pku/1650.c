double a,b,d;l,j,k,x,y;main(i){scanf("%lf%d",&a,&l);for(x=y=1,d=20;i<=l;i++){for(k=0;k<2;k++){j=a*i+k;if(j>l)j=l;b=(double)j/i;if(fabs(a-b)<d&&j)d=fabs(a-b),x=j,y=i;}}printf("%d %d\n",x,y);}
