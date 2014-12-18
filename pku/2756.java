import java.util.*;
import java.math.*;

public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int i=0;i<t;i++){
      String s = sc.next();
      if(s.indexOf('+')!=-1)s=s.substring(1);
      BigInteger a = new BigInteger(s);
      s = sc.next();
      if(s.indexOf('+')!=-1)s=s.substring(1);
      BigInteger b = new BigInteger(s);
      a=a.add(b);
      System.out.println(a);
    }
  }
}

