import java.util.*;

public class Main {

  public static void main(String args[]) {

    Scanner scan = new Scanner(System.in);
    int total_train = scan.nextInt();
    for(int tot = 0;tot < total_train;tot++) {
      String train = scan.next();
      String[] parts = new String[4]; //mae,maer,uriso,urisor;
      int total = 0,t = 0;
      String[] ss = new String[10000];
      for(int i = 1;i < train.length();i++) {
        //System.out.print(i + ":" + (train.length() - i) + "  ");
        //t = 0;
        parts[0] = train.substring(0,i);
        parts[1] = train.substring(i,train.length());
        parts[2] = reverse(parts[0]);
        parts[3] = reverse(parts[1]);
        for(int j = 0;j < 4;j++) {
          for(int k = 0;k < 2;k++) {
            String temp = parts[j] + parts[(j + 1 + k * 2) % 4];
            int l;
            for(l = 0;l < total;l++) {
              if(ss[l].equals(temp)) break;
            }
            if(l == total) {
              ss[total++] = temp;
              //System.out.print(temp + " ");
            }
          }
        }
        //total += t;
        //System.out.println();
      }
      System.out.println(total);
    }

  }

  private static String reverse(String s) {
    String rev = "";
    for(int i = s.length() - 1;i >= 0;i--) {
      rev += s.charAt(i);
    }
    return rev;
  }

}


