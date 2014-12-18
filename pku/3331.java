import java.util.*;
import java.math.*;

public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(;t>0;t--){
      int f = sc.nextInt();
      int d = sc.nextInt();
      BigInteger ans = new BigInteger(""+1);
      for(int i=2;i<=f;i++){
        ans = ans.multiply(new BigInteger(""+i));
      }
      String s = ans.toString();
      int n=0;
      for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='0'+d)n++;
      }
      System.out.println(n);
    }
  }
}

