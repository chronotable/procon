import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    int o = sc.nextInt();
    for(;o > 0; o--){
      long m = sc.nextLong();
      int y = sc.nextInt();
      int n = sc.nextInt();
      int[] v = new int[n];
      int[] r = new int[n];
      for(int i = 0; i < n; i++){
        v[i] = sc.nextInt() / 1000;
        r[i] = sc.nextInt();
      }
      for(int i = 0; i < y; i++){
        int tot = (int)(m / 1000);
        int[] dp = new int[tot+1];
        for(int j = 0; j < n; j++){
          for(int k = 0; k <= tot - v[j]; k++)
            dp[k + v[j]] = max(dp[k+v[j]], dp[k] + r[j]);
        }
        m = dp[tot] + m;
      }
      System.out.println(m);
    }
  }
}
