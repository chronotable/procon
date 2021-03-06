#include <stdio.h>

struct Edge{
    int u,v,next;
}Edges[100001];

int n,m;
int done[100001] = {0};
int first[10001] = {0};
int queue[100001];
int len = 0;

void add_edge(int u, int v, int i){
  Edges[i].u = u; Edges[i].v = v; Edges[i].next = first[u]; first[u] = i;
  Edges[i+1].u = v; Edges[i+1].v = u; Edges[i+1].next = first[v]; first[v] = i+1;
}

void dfs(int u){
  int v,x;
  x = first[u];
  while(x != 0){
    v = Edges[x].v;
    if(!done[x]){
      done[x] = 1;
      dfs(v);
      queue[++len] = x;
    }
    x = Edges[x].next;
  }
}

int main(){
  int i,a,b;
  scanf("%d%d",&n,&m);
  for(i = 1; i <= m; i++){
    scanf("%d%d",&a,&b);
    add_edge(a,b,i*2-1);
  }
  dfs(1);
  printf("%d\n%d\n", Edges[queue[len]].u, Edges[queue[len]].v);
  for(i = len-1; i>=1; i--)printf("%d\n", Edges[queue[i]].v);

  return 0;
}
