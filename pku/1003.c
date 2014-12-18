main(){
  double f,a;
  int n;
  for(;scanf("%lf",&f),f!=0.00;) {
    for(n=2,a=.0;a<f;a+=1.0/n++);
    printf("%d card(s)\n",n-2);
  }
}
