import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;sc.hasNext();){
	    String num = sc.next();
	    boolean cyclic = true;
	    for(int i =2;i <= num.length();i++){
		BigInteger b =
		    new BigInteger(num).multiply(new BigInteger(""+i));
		String mul = b.toString();
		if(mul.length() > num.length()){
		    cyclic=false;
		    break;
		}
		while(mul.length() < num.length())mul = "0"+mul;
		boolean same = false;
		for(int j = 0; j < num.length();j++){
		    int k;
		    for(k = 0; k < num.length();k++){
			if(mul.charAt((j+k)%mul.length())!=num.charAt(k))
			    break;
		    }
		    if(k==num.length()){
			same=true;
			break;
		    }
		}
		if(!same){
		    cyclic=false;
		    break;
		}
	    }
	    System.out.print(num + " is ");
	    if(cyclic)System.out.println("cyclic");
	    else System.out.println("not cyclic");
	}
    }
}