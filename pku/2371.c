n,s[100000];
int cmp(const void* a,const void* b){
  return (*(int*)a)-(*(int*)b);
}
int main(i,c){
  scanf("%d",&n);
  for(i=0;i<n;i++)scanf("%d",s+i);
  qsort(s,n,sizeof(int),cmp);
  scanf("%s%d",c,&i);
  for(;~scanf("%d",&i);)printf("%d\n",s[i-1]);
}
