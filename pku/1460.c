#include <stdio.h>
#include <string.h>
#include <assert.h>
int ans;
char* s;
int dbz;

int eval(char op,int l,int r){
  switch(op) {
    case '+': return l+r;
    case '-': return l-r;
    case '*': return l*r;
    case '/':
      if(r == 0) {dbz = 1;return 0;}
      return l/r;
    default:
      assert(0);
  }
}

int term(){
  int v;
  if(isdigit(*s)) {
    v = *s++ - '0';
    while(isdigit(*s)) v = v * 10 + *s++ - '0';
    return v;
  }
  assert(*s++ == '(');
  v = parse();
  assert(*s++ == ')');
  return v;
}

int factor() {
  int l = term();
  while(*s && (*s=='*' || *s=='/')) {
    char op=*s++;
    int r = term();
    l=eval(op,l,r);
  }
  return l;
}

int parse(){
  int l = factor();
  while(*s && *s != ')') {
    char op = *s++;
    int r = factor();
    l = eval(op,l,r);
  }
  return l;
}

char op[4] = {'+','-','*','/'};
int search(char* e) {
  int v;
  char* q = strchr(e,'?');
  if(q == NULL) {
    s = e;
    dbz = 0;
    v = parse();
    return ans==v && !dbz;
  }
  for(v=0;v<4;v++){
    *q=op[v];
    if(search(e))return 1;
  }
  *q='?';
  return 0;
}

int main(){
  int t;
  char exp[2000];
  scanf("%d",&t);
  for(;t>0;t--) {
    scanf("%s%d",exp,&ans);
    printf(search(exp)?"yes\n":"no\n");
  }
}
