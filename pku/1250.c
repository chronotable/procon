char m[99];s[26],n,i,a,b,j,k;main(c){for(;scanf("%d",&n),n;memset(s,0,sizeof(s))){scanf("%s",m);for(a=c=i=0;i<strlen(m);i++){if(!s[m[i]-'A']&&n){s[m[i]-'A']=-1,n--;}else if(!s[m[i]-'A']&&!n){s[m[i]-'A']=++c;}else if(s[m[i]-'A']==-1){s[m[i]-'A']=0;n++;for(b=1000,j=0;j<26;j++)if(s[j]>0&&s[j]<b)b=s[j],k=j;if(b!=1000)s[k]=-1,n--;}else if(s[m[i]-'A']>0){s[m[i]-'A']=0;a++;}}printf(a?"%d customer(s) walked away.\n":"All customers tanned successfully.\n",a);}}
