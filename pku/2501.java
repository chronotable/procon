import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  
  void run(){
    Scanner sc = new Scanner(System.in);
    double sp = 0;
    double dis = 0;
    int prevsec = 0;
    for(;sc.hasNext();){
      String line = sc.nextLine();
      int h = Integer.parseInt(line.substring(0,2));
      int m = Integer.parseInt(line.substring(3,5));
      int s = Integer.parseInt(line.substring(6,8));
      int t = h * 3600 + m * 60 + s;
      dis += (t-prevsec) / 3600.0 * sp;
      prevsec = t;
      if(line.length() > 8){
        sp = Double.parseDouble(line.split(" ")[1]);
      }else{
        System.out.printf("%s %.2f km\n", line, dis);
      }
    }
  }
}
