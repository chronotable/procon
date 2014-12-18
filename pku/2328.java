
import java.util.*;

public class Main{

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int l,r;
	for(;;){
	    l = 0;
	    r = 11;
	    int ans = 999;
	    for(;;){
		int n = sc.nextInt();
		if(n==0)return;
		String pre = sc.next();
		String suf = sc.next();
		if(pre.equals("right")){
		    ans = n;
		    break;
		}
		if(suf.equals("high") && r > n)r=n;
		else if(suf.equals("low") && n > l) l=n;
	    }
	    if(l<r && l < ans && ans < r){
		System.out.println("Stan may be honest");
	    }else{
		System.out.println("Stan is dishonest");
	    }
	}
    }

}
