import java.util.*;
import static java.lang.Math.*;

public class Main{
  public static void main(String[] args){
    new Main().run();
  }
  void run(){
    Scanner sc = new Scanner(System.in);
    for(;;){
      String s = sc.next();
      if(s.equals("*"))break;
      int n = s.length();
      int len = 0;
      loop:
      for(len = 0;len < n; len++){
        TreeSet<String> ts = new TreeSet<String>();
        for(int i = 0; i < n;i++){
          int j = i + len + 1;
          if(j >= n)break;
          String t = "" + (s.charAt(i)) + (s.charAt(j));
          if(ts.contains(t))break loop;
          ts.add(t);
        }
      }
      System.out.printf("%s is ", s);
      if(len < n)System.out.printf("NOT ");
      System.out.println("surprising.");
    }
  }
}
