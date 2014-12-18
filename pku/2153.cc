#include <iostream>
#include <map>
#include <string>
using namespace std;

int cmp(const void* a,const void* b){
  return (*(int*)b)-(*(int*)a);
}

int main(){
  map<string, int> tbl;
  map<string, int>::iterator it;
  int score[10000],cp[10000];
  string str,name,master="Li Ming";
  int n,m,value,i,j,k,lm;
  cin >> n;getline(cin,str);
  for(i=0;i<n;i++){
    getline(cin,str);
    tbl.insert(map<string, int>::value_type(str,i));
  }
  for(i=0;i<n;i++)score[i]=0;
  cin >> m;getline(cin,str);
  for(i=0;i<m;i++){
    for(j=0;j<n;j++){
      getline(cin,str);
      for(value=k=0;isdigit(str[k]);k++)value=value*10+str[k]-'0';
      name=str.substr(k+1,str.size()-k-1);
      it=tbl.find(name);
      score[(*it).second]+=value;
      for(k=0;k<master.size();k++)if(name[k]!=master[k])break;
      if(k==master.size())lm=score[(*it).second];
    }
    for(j=0;j<n;j++)cp[j]=score[j];
    qsort(cp,n,sizeof(int),cmp);
    for(j=0;j<n;j++)if(cp[j]==lm)break;
    cout << j+1 << endl;
  }
}
