import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  void run(){
    Scanner sc = new Scanner(System.in);
    for(;;){
      int h = sc.nextInt();
      int w = sc.nextInt();
      if(w+h==0)break;
      int n = sc.nextInt();
      double[][] s = new double[h][w];
      double d = 1.0;
      for(int o = 0; o < n; o++){
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int mnx = min(x1, x2);
        int mxx = max(x1, x2);
        int mny = min(y1, y2);
        int mxy = max(y1, y2);
        for(int i = mny; i < mxy; i++){
          for(int j = mnx; j < mxx; j++){
            s[i][j] += d;
          }
        }
        d *= 2.0;
      }
      int ans = 0;
      boolean[][] u = new boolean[h][w];
      for(int i = 0; i < h; i++){
        for(int j = 0; j < w; j++){
          if(u[i][j]) continue;
          ans++;
          tra(i, j, s, u);
        }
      }
      System.out.println(ans);
    }
  }
  int[] dx = new int[]{1, 0, -1, 0};
  int[] dy = new int[]{0, 1, 0, -1};
  void tra(int y, int x, double[][] s, boolean[][] u){
    if(u[y][x])return;
    u[y][x] = true;
    for(int i = 0; i < dx.length; i++){
      int ny = y + dy[i];
      int nx = x + dx[i];
      if(ny < 0 || ny >= s.length || nx < 0 || nx >= s[0].length ||
         u[ny][nx] || abs(s[y][x]-s[ny][nx]) > 1e-9)continue;
      tra(ny, nx, s, u);
    }
  }
}
