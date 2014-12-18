p[100001],n,c,a,i;
f(const void* x,const void* y){
  return (*(int*)x)-(*(int*)y);
}
d(l,r){
  int m=(l+r)/2,w=p[0],e=1,j;
  for(j=1;j<n;j++)if(p[j]-w>=m)e++,w=p[j];
  if(a<m&&e>=c)a=m;
  if(e>=c&&m+1<=r)d(m+1,r);
  else if(l<=m-1)d(l,m-1);
}
main(){
  scanf("%d%d",&n,&c);
  for(i=0;i<n;i++)scanf("%d",p+i);
  qsort(p,n,sizeof(int),f);
  d(0,p[n-1]-p[0]);
  printf("%d",a);
}
