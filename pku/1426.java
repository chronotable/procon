import java.util.*;

public class Main{
  public static void main(String[] args){
    PriorityQueue<Info> q = new PriorityQueue<Info>();
    Scanner sc = new Scanner(System.in);
    int n;
    for(;;){
      n = sc.nextInt();
      if(n==0)break;
      q.clear();
      q.offer(new Info(1,"1"));
      boolean[] u = new boolean[n];
      String ans=null;
      while(!q.isEmpty()){
        Info t = q.poll();
        int mod = t.v % n;
        if(mod == 0){
          ans = t.s;
          break;
        }
        if(u[mod])continue;
        u[mod] = true;
        q.offer(new Info(mod * 10 + 1,t.s + "1"));
        q.offer(new Info(mod * 10,t.s + "0"));
      }
      System.out.println(ans);
    }
  }
}
class Info implements Comparable<Info>{
  int v;
  String s;
  Info(int a, String b){
    v = a;
    s = b;
  }
  public int compareTo(Info i){
    return this.s.length() - i.s.length();
  }
}