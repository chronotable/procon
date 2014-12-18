import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    String a = sc.next();
	    String b = sc.next();
	    if(a.equals("0") && b.equals("0"))break;
	    if(a.length() < b.length()){
		while(a.length() < b.length())a = "0" + a;
	    }else if(a.length() > b.length()){
		while(b.length() < a.length())b = "0" + b;
	    }
	    int ans = 0;
	    int carry = 0;
	    for(int i  = a.length()-1; i >= 0;i--){
		int x = a.charAt(i) - '0';
		int y = b.charAt(i) - '0';
		int v = x + y + carry;
		if(v > 9){
		    ans++;
		    carry = 1;
		}else{
		    carry = 0;
		}
	    }
	    if(ans==0)System.out.println("No carry operation.");
	    else if(ans==1)System.out.println("1 carry operation.");
	    else System.out.println(ans + " carry operations.");
	}
    }
}