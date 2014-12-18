import java.util.*;
import java.math.*;

public class Main{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	ArrayList<BigDecimal> ar = new ArrayList<BigDecimal>();
	ar.add(new BigDecimal("1").divide(new BigDecimal("8")));
	for(;sc.hasNext();){
	    String s = sc.next();
	    String org = s;
	    s = s.substring(2);
	    BigDecimal ans = new BigDecimal("0");
	    for(int i = 0; i < s.length();i++){
		if(i == ar.size())
		    ar.add(ar.get(ar.size()-1).divide(new BigDecimal("8")));
		ans = ans.add(ar.get(i).multiply(new BigDecimal(""+s.charAt(i))));
	    }
	    System.out.println(org + " [8] = " + ans + " [10]");
	}
    }
}