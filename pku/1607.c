double t[100000];
main(i){
  for(printf("Cards  Overhang\n");i<100000;i++)t[i]=t[i-1]+1.0/(2.0*i);
  for(;~scanf("%d",&i);)printf("%5d     %.3lf\n",i,t[i]);
}