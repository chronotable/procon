import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n;
    int a,b;
    int hd,max;
    while(true) {
      n = scan.nextInt();
      if(n == 0) break;
      hd = 0;
      max = 0;
      for(int i = 0;i < n;i++) {
        a = scan.nextInt();
        b = scan.nextInt();
        if(a + b > 8) {
          if(a + b > max) {
            max = a + b;
            hd = i + 1;
          }
        }
      }
      System.out.println(hd);
    }
  }
}

