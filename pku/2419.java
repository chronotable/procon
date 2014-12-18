import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  void run(){
    Scanner sc = new Scanner(System.in);
    int p = sc.nextInt();
    int t = sc.nextInt();
    boolean[][] heard = new boolean[p][t];
    for(;sc.hasNext();){
      int i = sc.nextInt() - 1;
      int j = sc.nextInt() - 1;
      heard[i][j] = true;
    }
    int ans = 0;
    for(int i = 0; i < p;i++){
      boolean f = true;
      for(int j = 0; j < i;j++){
        int k = 0;
        for(k = 0; k < t;k++)if(heard[i][k] != heard[j][k])break;
        if(k == t){
          f = false;
          break;
        }
      }
      if(f)ans++;
    }
    System.out.println(ans);
  }
}

