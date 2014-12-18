import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    double[] x = new double[n];
    double[] y = new double[n];
    Edge[] e = new Edge[n*(n-1)/2];
    int a = 0;
    for(int i = 0;i < n;i++){
      x[i]=sc.nextDouble();
      y[i]=sc.nextDouble();
      for(int j = 0;j < i;j++){
        e[a++]=new Edge(i,j,Math.hypot(x[i]-x[j],y[i]-y[j]));
      }
    }
    UnionFind uf = new UnionFind(n);
    Arrays.sort(e);
    double ans = 0.0;
    for(int i = 0; i < a;i++){
      if(uf.find(e[i].a,e[i].b)) continue;
      uf.unite(e[i].a,e[i].b);
      ans += e[i].c;
    }
    System.out.printf("%.2f\n",ans);
  }
}
  
  class Edge implements Comparable<Edge>{
    double c;
    int a,b;
    Edge(int a,int b,double c){
      this.c = c;
      this.a = a;
      this.b = b;
    }
    public int compareTo(Edge ed){
      if(c<ed.c)return -1;
      else if(c>ed.c) return 1;
      else return 0;
    }
  }
  
  class UnionFind{
    int [] par,size;
    UnionFind(int n){
      par = new int[n];
      size = new int[n];
      for(int i = 0; i < n;i++){
        par[i]=i;
        size[i]=1;
      }
    }
    public int parent(int x){
      return par[x]==x ? x : (par[x]=parent(par[x]));
    }
    public void unite(int x,int y){
      x = parent(x);
      y = parent(y);
      if(size[x] < size[y]){
        int t = x;
        x = y;
        y = t;
      }
      par[y]=x;
      size[x] += size[y];
    }
    public boolean find(int x, int y){
      return parent(x) == parent(y);
    }
  }



