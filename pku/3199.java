import java.math.*;
import java.util.*;
public class Main{public static void main(String[] args){Scanner sc=new Scanner(System.in);for(;;){int n=sc.nextInt(),d=sc.nextInt();if(n==0)break;BigInteger i=new BigInteger(""+n);System.out.println(i.pow(d));}}}
