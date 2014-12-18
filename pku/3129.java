import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  void run(){
    Scanner sc = new Scanner(System.in);
    for(;;){
      int n = sc.nextInt();
      if(n==0)break;
      double[][] star = new double[n][3];
      boolean[] u = new boolean[n];
      for(int i = 0; i < n;i++){
        for(int j = 0; j < 3; j++)star[i][j] = sc.nextDouble();
      }
      int m = sc.nextInt();
      int ans = 0;
      for(int i = 0; i < m;i++){
        double[] ts = new double[3];
        for(int j = 0; j < 3;j++)ts[j] = sc.nextDouble();
        double ang = sc.nextDouble();
        for(int j = 0; j < n;j++){
          if(u[j])continue;
          double a = sqrt(norm(ts,ts));
          double b = sqrt(norm(star[j],star[j]));
          double phi = acos(norm(ts, star[j]) / (a*b));
          if(abs(phi) < ang){
            u[j] = true;
            ans++;
          }
        }
      }
      System.out.println(ans);
    }
  }
  double norm(double[] a, double[] b){
    return a[0]*b[0] + a[1]*b[1] + a[2]*b[2];
  }
}
