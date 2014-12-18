import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  void run(){
    Scanner sc = new Scanner(System.in);
    int o = sc.nextInt();
    for(;o > 0;o--){
      int m = sc.nextInt();
      int[] dis = new int[m];
      for(int i = 0; i < m;i++)dis[i] = sc.nextInt();
      Info[] tbl = new Info[1010];
      tbl[0] = new Info(0,"");
      for(int i = 0; i < m;i++){
        Info[] nt = new Info[1010];
        for(int j = 0; j < tbl.length;j++){
          if(tbl[j] != null){
            int uv = j + dis[i], dv = j - dis[i];
            if(uv < 1001){
              if(nt[uv] == null || (nt[uv].height > max(uv, tbl[j].height))){
                nt[uv] = new Info(max(uv, tbl[j].height), tbl[j].cmd + "U");
              }
            }
            if(dv >= 0){
              if(nt[dv] == null || (nt[dv].height > max(dv, tbl[j].height))){
                nt[dv] = new Info(max(dv, tbl[j].height), tbl[j].cmd + "D");
              }
            }
          }
        }
        tbl = nt;
      }
      if(tbl[0] != null)System.out.println(tbl[0].cmd);
      else System.out.println("IMPOSSIBLE");
    }
  }
  class Info{
    int height;
    String cmd;
    Info(int a, String b){
      height = a;
      cmd = b;
    }
  }
}
