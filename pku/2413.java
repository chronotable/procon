import java.util.*;
import java.math.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    BigInteger[] tbl = new BigInteger[5000];
    tbl[0] = new BigInteger("1");
    tbl[1] = new BigInteger("2");
    for(int i = 2;i < 5000;i++)tbl[i]=tbl[i-1].add(tbl[i-2]);
    for(;;){
      String l = sc.next();
      String r = sc.next();
      if(l.equals("0") && r.equals("0"))break;
      BigInteger low = new BigInteger(l);
      BigInteger high = new BigInteger(r);
      int p = -(Arrays.binarySearch(tbl,low))-1;
      if(p<0)p=0;
      int ans=0;
      for(;tbl[p].compareTo(high) <= 0;p++)
        if(tbl[p].compareTo(low) >= 0)ans++;
      System.out.println(ans);
    }
  }
}

