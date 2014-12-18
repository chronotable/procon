import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    for(int o = sc.nextInt(); o > 0; o--){
      int n = sc.nextInt();
      long ans = 1;
      for(int i = 0; i < n; i++){
        long v = sc.nextLong();
        ans = lcm(ans, v);
      }
      if(ans <= 1000000000L)System.out.println(ans);
      else System.out.println("More than a billion.");
    }
  }
  
  long gcd(long a, long b){
    if(a < b)return gcd(b, a);
    return b == 0 ? a : gcd(b, a % b);
  }
  
  long lcm(long a, long b){
    return a / gcd(a, b) * b;
  }
}

