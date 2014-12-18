a,i;main(n,c){for(gets(c);~scanf("%d%d",&n,&i);a=0){i-=n;n=sqrt(i);if(n){a+=n*2-1;i-=n*n;a+=i/n;if(i%n)a++;}printf("%d\n",a);}}
