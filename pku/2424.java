import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  void run(){
    Scanner sc = new Scanner(System.in);
    for(;;){
      int[] cap = new int[3];
      for(int i = 0; i < 3;i++)cap[i] = sc.nextInt();
      if(cap[0] == 0)break;
      int ans = 0;
      int at;
      Queue<Integer>[] q = new LinkedList[3];
      for(int i = 0; i < 3;i++)q[i] = new LinkedList<Integer>();
      for(;;){
        String s = sc.next();
        if(s.equals("#"))break;
        at = parse(s);
        int n = sc.nextInt();
        int n2 = (n-1)/2;
        while(!q[n2].isEmpty() && q[n2].peek() < at)q[n2].poll();
        int st = 10000;
        if(q[n2].size() < cap[n2])st = at;
        else if(q[n2].peek() <= at + 30) st = q[n2].poll();
        if(st == 10000) continue;
        ans += n;
        q[n2].offer(st + 30);
      }
      System.out.println(ans);
    }
  }
  int parse(String s){
    return Integer.parseInt(s.substring(0,2)) * 60 +
           Integer.parseInt(s.substring(3));
  }
}

