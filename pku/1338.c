u[1501],r,s,t,n;m(x,y){return x>y?y:x;}main(i){for(r=s=t=u[1]=i;i<1500;){n=m(u[r]*2,u[s]*3);u[++i]=n=m(n,u[t]*5);if(n==u[r]*2)r++;if(n==u[s]*3)s++;if(n==u[t]*5)t++;}for(;scanf("%d",&n),n;)printf("%d\n",u[n]);}
