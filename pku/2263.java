import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    for(int o = 1;;o++){
      int n = sc.nextInt();
      int r = sc.nextInt();
      if(n+r==0)break;
      int[][] path = new int[n][n];
      HashMap<String, Integer> hm = new HashMap<String, Integer>();
      for(int i = 0; i < r;i++){
        String s = sc.next();
        if(!hm.containsKey(s))hm.put(s, hm.size());
        String t = sc.next();
        if(!hm.containsKey(t))hm.put(t, hm.size());
        int a = hm.get(s);
        int b = hm.get(t);
        int c = sc.nextInt();
        path[a][b] = path[b][a] = Math.max(path[a][b],c);
      }
      String start = sc.next();
      String dest = sc.next();
      int[] dp = new int[n];
      PriorityQueue<Info> q = new PriorityQueue<Info>();
      q.offer(new Info(hm.get(start),10000));
      while(!q.isEmpty()){
        Info temp = q.poll();
        if(dp[temp.p] >= temp.m)continue;
        dp[temp.p] = temp.m;
        for(int i = 0; i < n;i++){
          if(path[temp.p][i] > 0){
            int x = Math.min(temp.m,path[temp.p][i]);
            q.offer(new Info(i,x));
          }
        }
      }
      System.out.println("Scenario #" + o);
      System.out.println(dp[hm.get(dest)] + " tons");
      System.out.println();
    }
  }
  
  static class Info implements Comparable<Info>{
    int p,m;
    Info(int a,int b){
      p=a;
      m=b;
    }
    public int compareTo(Info i){
      return i.m - this.m;
    }
  }
}


