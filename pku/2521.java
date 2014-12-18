import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n,m,p,c;
    while(true) {
      n = scan.nextInt();
      m = scan.nextInt();
      p = scan.nextInt();
      c = scan.nextInt();
      if(n == 0 && m == 0 && p == 0 && c == 0) break;
      int lost = n + c - (m + c - p);
      System.out.println(lost);
    }
  }
}

