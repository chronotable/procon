import java.util.*;

public class Main{

  public static void main(String args[]){
    ArrayList<String> nl = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);
    double source = sc.nextDouble();
    int n = sc.nextInt();
    double[][] con = new double[n][n];
    boolean[] visited = new boolean[n];
    for(int i = 0; i < n;i++)nl.add(sc.next());
    int m = sc.nextInt();
    for(int i = 0; i < m;i++) {
      int s = nl.indexOf(sc.next());
      int e = nl.indexOf(sc.next());
      con[s][e]=con[e][s]=sc.nextDouble();
    }
    double ans = 0.0;
    PriorityQueue<Edge> q = new PriorityQueue<Edge>();
    q.offer(new Edge(0,0.0));
    while(!q.isEmpty()){
      Edge elm = q.poll();
      if(visited[elm.to])continue;
      visited[elm.to]=true;
      double val = elm.cost;
      ans+=val;
      for(int i = 0;i<n;i++){
        if(con[elm.to][i]>0.0){
          q.offer(new Edge(i,con[elm.to][i]));
        }
      }
    }
    if(ans > source) {
      System.out.println("Not enough cable");
    }else{
      System.out.printf("Need %.1f miles of cable",ans);
    }
  }

  static class Edge implements Comparable<Edge>{
    int to;
    double cost;
    Edge(int t, double c){
      this.to = t;
      this.cost = c;
    }
    
    public int compareTo(Edge e) {
      if(this.cost - e.cost < 0) return -1;
      else if(this.cost - e.cost > 0) return 1;
      else return 0;
    }
  }

}

