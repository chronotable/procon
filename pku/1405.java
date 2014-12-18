import java.util.*;
import java.math.*;
public class Main{
  public static void main(String args[]) {
    BigInteger[] ans = new BigInteger[18];
    ans[0] = new BigInteger("2");
    for(int i=1;i<18;i++){
      ans[i]=ans[i-1].multiply(ans[i-1]).subtract(ans[i-1]).add(new BigInteger("1"));
    }
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    for(int i=0;i<n;i++)System.out.println(ans[i]);
  }
}
