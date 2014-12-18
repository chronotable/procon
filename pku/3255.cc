#include<iostream> 
#include<algorithm> 
#include<queue> 
#include<vector> 
#include<cstdio> 
#include<cstring> 
#include<cctype> 
using namespace std; 
 
#define REP(i,n) for(int i=0;i<(int)(n);i++) 
 
struct Edge { 
  int dst, weight; 
}; 
 
vector<Edge> g[5000]; 
 
int NextInt() { 
  int r = 0, ch; 
  while( isspace(ch = getchar()) ); 
  do { 
    r = r * 10 + ch - '0'; 
  } while( isdigit( ch = getchar() ) ); 
  return r; 
} 
 
int SecondShortestPath(int N) { 
  const int inf = 987654321; 
  int memo[2][5000]; 
  REP(i, 5000) { 
    memo[0][i] = inf; 
    memo[1][i] = inf; 
  } 
 
  priority_queue< pair<int,int> > up; 
  up.push( make_pair(0, 0) ); 
  while( !up.empty() ) { 
    int dist = -up.top().first; 
    int pos = up.top().second; 
    up.pop(); 
 
    if( memo[0][pos] > dist ) memo[0][pos] = dist; 
    else if( memo[1][pos] > dist ) memo[1][pos] = dist; 
    else continue; 
 
    if( memo[1][N-1] != inf ) return memo[1][N-1]; 
 
    for(int i = 0; i < (int)g[pos].size(); i++) { 
      up.push( make_pair( -(dist + g[pos][i].weight), g[pos][i].dst ) ); 
    } 
  } 
  return -1; 
} 
 
int main() { 
  int N = NextInt(); 
  int M = NextInt(); 
  REP(i, M) { 
    int a = NextInt() - 1; 
    int b = NextInt() - 1; 
    int c = NextInt(); 
    g[a].push_back( (Edge){b, c} ); 
    g[b].push_back( (Edge){a, c} ); 
  } 
  cout << SecondShortestPath(N) << endl; 
}