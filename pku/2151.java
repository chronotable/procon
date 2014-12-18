import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  void run(){
    Scanner sc = new Scanner(System.in);
    for(;;){
      int m = sc.nextInt();
      int t = sc.nextInt();
      int n = sc.nextInt();
      if(m+n+t==0)break;
      double[] a = new double[t];
      double[] b = new double[t];
      for(int i = 0; i < t;i++){
        double[] p = new double[m+1];
        for(int j = 1; j <= m;j++)p[j] = sc.nextDouble();
        double[][] dp = new double[m+1][m+1];
        dp[0][0] = 1.0;
        for(int j = 1; j <= m;j++){
          dp[j][0] = dp[j-1][0] * (1.0-p[j]);
          for(int k = 1; k <= j;k++)
            dp[j][k] = dp[j-1][k-1]*p[j] + dp[j-1][k] * (1.0-p[j]);
        }
        a[i] = 1.0 - dp[m][0];
        b[i] = 0.0;
        for(int j = 1; j < n;j++)b[i] += dp[m][j];
      }
      double A = 1.0, B = 1.0;
      for(int i = 0; i < t;i++){
        A *= a[i];
        B *= b[i];
      }
      System.out.printf("%.3f\n", A-B);
    }
  }
}
