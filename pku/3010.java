import java.util.*;

public class Main {

  private static int n;

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    String s;
    while(true) {
      s = scan.next();
      n = scan.nextInt();
      if(s.equals("0") && n == 0) break;

      if(analyze(s,0) > 0) System.out.println(0);
    }
  }

  private static int analyze(String s,int start) {
    int c = 0,i = 0;
    while(i < s.length()) {
      if(start + c == n) {
        while((s.charAt(i) >= '0' && s.charAt(i) <= '9') ||
               s.charAt(i) == '(' || s.charAt(i) == ')') i++;
        System.out.println(s.charAt(i));
        return -1;
      }else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        int t = i;
        while(s.charAt(i) >= '0' && s.charAt(i) <= '9') i++;
        int num = Integer.parseInt(s.substring(t,i));
        if(s.charAt(i) == '(') {
          i++;
          t = i;
          int brace = 0;
          boolean flag = true;
          while(flag) {
            if(s.charAt(i) == '(') {
              brace++;
            }else if(s.charAt(i) == ')') {
              if(brace == 0) {
                flag = false;
                int originalc = c;
                int len = analyze(s.substring(t,i),start + c);
                int record = num * len;
                if(record < 0) return -1;
                else c += record;

                if(c + start > n){
                  int j = 1;
                  while(start + originalc + len  * j <= n) j++;
                  j--;
                  analyze(s.substring(t,i),start + originalc + len * j);
                  return -1;
                }
                i--;

              }else {
                brace--;
              }
            }
            i++;
          }
        }else {
          c += num;
          if(c + start > n) {
            System.out.println(s.charAt(i));
            return -1;
          }
        }
      }else {
        c++;
      }
      i++;
    }
    return c;
  }
}

