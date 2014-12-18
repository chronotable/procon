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
      if(n < 0)break;
      n--;
      int len = (int)pow(3, n);
      boolean[][] x = new boolean[len][len];
      tra(x, len/2, len/2, len);
      for(int i = 0; i < len; i++){
        StringBuilder sb = new StringBuilder("");
        for(int j = 0; j < len; j++){
          sb.append(x[i][j] ? "X" : " ");
          //System.out.printf("%s", x[i][j] ? "X" : " ");
        }
        System.out.println(sb);
      }
      System.out.println("-");
    }
  }
  
  void tra(boolean[][] x, int cx, int cy, int len){
    if(len == 1){
      x[cy][cx] = true;
      return;
    }
    len /= 3;
    tra(x, cx, cy, len);
    tra(x, cx-len, cy-len, len);
    tra(x, cx+len, cy-len, len);
    tra(x, cx-len, cy+len, len);
    tra(x, cx+len, cy+len, len);
  }
}
