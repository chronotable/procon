import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(;n>0;n--){
      int s = sc.nextInt();
      int fig = 1;
      while(s >= 10){
        s += 5;
        s -= s%10;
        s /= 10;
        fig *= 10;
      }
      s *= fig;
      System.out.println(s);
    }
  }
}
