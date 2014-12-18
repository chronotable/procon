#include<iostream>
#include<map>
using namespace std;
main(){map<string,string> d;map<string,string>::iterator it;char s[128],a[64],b[64];for(;gets(s),s[0]>='a'&&s[0]<='z';){sscanf(s,"%s %s",a,b);string x=a,y=b;d.insert(map<string,string>::value_type(y,x));}for(;~scanf("%s",s);){string k=s;if((it=d.find(k))!=d.end())cout<<it->second<<endl;else puts("eh");}}
