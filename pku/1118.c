ans,x[701],y[701],n,i,j,k;
double s[701][701];

int cmp(const void* a,const void* b){
  double c=(*(double*)a),d=(*(double*)b);
  if(c<d)return -1;
  else if(c>d)return 1;
  else return 0;
}

main(){
  for(;scanf("%d",&n),n;ans=0){
    for(i=0;i<n;i++)scanf("%d%d",x+i,y+i);
    for(i=0;i<n;i++){
      for(k=j=0;j<n;j++){
        if(i==j)continue;
        if(x[i]-x[j]==0)s[i][k++]=1<<30;
        else if(y[i]-y[j]==0)s[i][k++]=0;
        else s[i][k++]=(double)(abs(y[i]-y[j]))/abs(x[i]-x[j]);
      }
      qsort(s[i],n-1,sizeof(double),cmp);
      for(k=j=0;j<n-2;j++){
        if(s[i][j]==s[i][j+1]){
          k++;
        }else{
          if(k+1>ans)ans=k+1;
          k=0;
        }
      }
      if(k+1>ans)ans=k+1;
    }
    printf("%d\n",ans+1);
  }
}

