import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if(n==1){
      System.out.println("0");
      return;
    }
    int[] xs = new int[n];
    int[] ys = new int[n];
    for(int i = 0; i < n; i++){
      int x = sc.nextInt();
      int y = sc.nextInt();
      xs[i] = x;
      ys[i] = y;
    }
    Arrays.sort(xs);
    Arrays.sort(ys);
    int ax, ay;
    if(n%2 == 1){
      ay = ys[n/2];
    }else{
      ay = (ys[n/2] + ys[n/2-1]) / 2;
    }
    int ans = 0;
    for(int i = 0; i < n; i++)ans += abs(ys[i] - ay);
    for(int i = 0; i < n; i++)xs[i] -= i;
    Arrays.sort(xs);
    if(n%2 == 1){
      ax = xs[n/2];
    }else{
      ax = (xs[n/2] + xs[n/2-1]) / 2;
    }
    for(int i = 0; i < n; i++)ans += abs(xs[i] - ax);
    System.out.println(ans);
  }
  
  /*
  int calc(P[] ps, int cx, int cy){
    int n = ps.length;
    int h = n / 2;
    int ret = 0;
    for(int i = 0; i < n; i++){
      ret += abs((cx - h + i)-ps[i].x) + abs(ps[i].y - cy);
    }
    return ret;
  }
  */
  /*
  class P implements Comparable<P>{
    int x,y;
    P(int a, int b){
      x = a;
      y = b;
    }
    public int compareTo(P p){
      if(this.x != p.x)return this.x - p.x;
      return this.y - p.y;
    }
  }
  */
}
