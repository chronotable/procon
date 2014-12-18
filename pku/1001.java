import java.util.*;

public class Main {

  private static final int M = 150;
  private static int[] c; //

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    String r = "";
    int n = 1;
    int fc; //figure count
    while(true) {
      if(scan.hasNext()) {
        r = scan.next();
        n = scan.nextInt();
      }else{
        break;
      }

      int z;
      for(z = r.length() - 1;z >= 0;z--) {
        if(r.charAt(z) != '0') break;
      }
      r = r.substring(0,z + 1);
      int num = Integer.parseInt(r.substring(0,r.indexOf('.')) +
                                 r.substring(r.indexOf('.') + 1,r.length()));
      fc = r.length() - 1 - r.indexOf('.');

      c = new int[M];
      c[0] = 1;
      int rest = 0;
      for(int i = 0;i < n;i++) {
        for(int j = 0;j < M;j++) {
          rest = c[j] * num + rest;
          c[j] = rest % 10;
          rest /= 10;
        }
      }
      fc *= n;

      int f;
      for(f = M - 1;f >= 0;f--) {
        if(c[f] != 0) break; 
      }

      if(fc > f) {
        System.out.print(".");
        for(int i = fc - 1;i >= 0;i--) {
          System.out.print(c[i]);
        }
      }else {
        for(;f >= fc;f--) {
          System.out.print(c[f]);
        }
        if(fc != 0) System.out.print(".");
        for(;f >= 0;f--) {
          System.out.print(c[f]);
        }
      }
      System.out.println();

    }
  }

}
