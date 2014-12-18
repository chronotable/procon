import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	BigInteger[] tp = new BigInteger[100];
	tp[0] = new BigInteger("1");
	for(int i = 1; i < 100;i++)
	    tp[i] = tp[i-1].multiply(new BigInteger("3"));
	for(;;){
	    String s = sc.next();
	    if(s.equals("0"))break;
	    BigInteger b = new BigInteger(s).subtract(new BigInteger("1"));
	    int count = 0;
	    ArrayList<String> ar = new ArrayList<String>();
	    while(!b.toString().equals("0")){
		int m = b.mod(new BigInteger("2")).intValue();
		if(m==1)
		    ar.add(tp[count].toString());
		count++;
		b = b.divide(new BigInteger("2"));
	    }
	    System.out.print("{");
	    for(int i = 0; i < ar.size()-1;i++)
		System.out.print(" " + ar.get(i) + ",");
	    if(ar.size()>0)
		System.out.println(" " + ar.get(ar.size()-1) + " }");
	    else System.out.println(" }");
	}
    }
}