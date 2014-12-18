import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int w = sc.nextInt();
    int h = sc.nextInt();
    int[] x = new int[n+1];
    int[] y = new int[n+1];
    for(int i = 1; i <= n; i++){
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }
    n++;
    int ansl = 0, ansp = 0, ansq = 0;
    for(int i = 0; i < n;i++){
      for(int j = 0; j < n;j++){
        int ox = x[i];
        int oy = y[j];
        int mx = min(w-ox, h-oy);
        for(int k = 0; k < n;k++){
          if(x[k] <= ox || y[k] <= oy)continue;
          mx = min(mx, max(x[k] - ox, y[k] - oy));
        }
        if(mx > ansl){
          ansl = mx;
          ansp = ox;
          ansq = oy;
        }
      }
    }
    System.out.printf("%d %d %d\n",ansp, ansq, ansl);
  }
}
