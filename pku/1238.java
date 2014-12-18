import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  void run(){
    Scanner sc = new Scanner(System.in);
    loop : for(;sc.hasNext();){
      int n = sc.nextInt();
      double[][] ds = new double[n][n];
      for(int i = 0; i < n;i++){
        for(int j = 0; j < n; j++){
          if(i!=j)ds[i][j] = sc.nextDouble();
        }
      }
      double[][][] mx = new double[n][n][n+2];
      Queue<Entry> q = new LinkedList<Entry>();
      for(int i = 0; i < n;i++){
        mx[i][i][0] = 1;
        q.offer(new Entry(i,i,0,1,null));
      }
      while(!q.isEmpty()){
        Entry e = q.poll();
        if(e.n > n)break;
        if(e.start == e.crt && e.d > 1.01){
          ArrayList<Integer> ar = new ArrayList<Integer>();
          while(e != null){
            ar.add(e.crt);
            e = e.prev;
          }
          for(int i = ar.size()-1;i >= 0;i--){
            System.out.print(ar.get(i) + 1);
            if(i > 0)System.out.print(" ");
          }
          System.out.println();
          continue loop;
        }
        for(int i = 0; i < n; i++){
          Entry f = new Entry(e.start, i, e.n + 1, e.d * ds[e.crt][i], e);
          if(mx[f.start][f.crt][f.n] < f.d){
            mx[f.start][f.crt][f.n] = f.d;
            q.offer(f);
          }
        }
      }
      System.out.println("no arbitrage sequence exists");
    }
  }
  class Entry{
    int start, crt, n;
    double d;
    Entry prev;
    Entry(int s, int c, int _n, double _d, Entry p){
      start = s;
      crt = c;
      n = _n;
      d = _d;
      prev = p;
    }
  }
}

