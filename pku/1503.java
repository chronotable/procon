import java.util.*;
class Main{
  public static void main(String args[]){
    java.math.BigInteger b=null,a=b.ZERO;
    for(Scanner s=new Scanner(System.in);a!=b;a=s.nextBigInteger().add(b=a));
    System.out.print(a);
  }
}
