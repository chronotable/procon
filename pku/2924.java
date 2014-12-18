
import java.util.*;
import static java.lang.Math.*;

public class Main{

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	for(int c = 1; c <= t;c++){
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    boolean minus = false;
	    long b,s;
	    if(abs(n) > abs(m)){
		b = abs(n);
		s = abs(m);
		if(n<0)minus=true;
	    }else{
		b = abs(m);
		s = abs(n);
		if(m<0)minus=true;
	    }
	    if((n>0 && m>0) || (n<0 && m<0))s--;
	    long ans = b * (b + 1) / 2l - s * (s + 1) / 2l;
	    if(minus) ans = -ans;
	    System.out.println("Scenario #" + c + ":");
	    System.out.println(ans);
	    System.out.println();
	}
    }

}
