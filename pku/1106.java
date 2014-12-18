import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    for(;;){
      int cx = sc.nextInt();
      int cy = sc.nextInt();
      double cr = sc.nextDouble();
      if(cr < 0)break;
      int n = sc.nextInt();
      int[] px = new int[n];
      int[] py = new int[n];
      int m = 0;
      for(int i = 0; i < n; i++){
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(hypot(cx - x, cy - y) <= cr){
          px[m] = x;
          py[m++] = y;
        }
      }
      int ans = 0;
      for(int i = 0; i < m; i++){
        int left = 0;
        int right = 0;
        for(int j = 0; j < m; j++){
          int v = (px[i] - cx)*(py[j]-cy) - (px[j]-cx)*(py[i]-cy);
          if(v <= 0)left++;
          if(v >= 0)right++;
        }
        ans = max(ans, max(left, right));
      }
      System.out.println(ans);
    }
  }
}

