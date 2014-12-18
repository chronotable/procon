u[9000000],a[500001];
main(i){
  for(u[0]=1;i<500001;u[a[i++]]=1)a[i]=a[i-1]-i>0&&!u[a[i-1]-i]?a[i-1]-i:a[i-1]+i;
  for(;scanf("%d",&i),~i;)printf("%d\n",a[i]);
}