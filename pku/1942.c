double a,w,h,m;
main(){
  for(;scanf("%lf%lf",&w,&h),w+h;){
    a=1.0;
    m=w+h;
    w=w<h?w:h;
    for(h=1;h<=w;h++)a=a*m--/h;
    printf("%.0lf\n",a);
  }
}
