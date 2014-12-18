import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    double K,A;
    int m,n;
    for(;;){
      K = sc.nextDouble();
      A = sc.nextDouble();
      m = sc.nextInt();
      n = sc.nextInt();
      if(m+n==0)break;
      double x = (sqrt(K*K + 4*m*n*K*A) - K) / (2 * m*n);
      System.out.printf("%.3f\n", - log10(x * m));
    }
  }
}
