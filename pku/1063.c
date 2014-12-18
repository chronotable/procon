n,m,i,j,s[50],o,e;
main(){
  for(scanf("%d",&n);n;n--){
    scanf("%d",&m);
    for(i=0;i<m;i++)scanf("%d",s+i);
    if(m%2){printf("YES\n");continue;}
    for(o=e=i=0;i<m;i++)if(s[i]){if(i%2)o++;else e++;}
    if(abs(o-e)<2)printf("YES\n");
    else printf("NO\n");
  }
}
