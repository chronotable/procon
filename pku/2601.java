import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] ags){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    double a0 = sc.nextDouble();
    double an1 = sc.nextDouble();
    double[] c = new double[n];
    for(int i = 0; i < n; i++)c[i] = sc.nextDouble();
    double low = -1e5;
    double high = 1e5;
    double m = low;
    for(int i = 0; i < 200; i++){
      m = (low + high) / 2;
      if(calc(c, a0, m) > an1)high = m;
      else low = m;
    }
    System.out.printf("%.2f\n", low);
  }
  
  double calc(double[] c, double a0, double a1){
    int n = c.length;
    double next = 0;
    for(int i = 0; i < n; i++){
      next = 2 * (a1 + c[i]) - a0;
      a0 = a1;
      a1 = next;
    }
    return a1;
  }
}
