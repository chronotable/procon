
import java.util.*;

public class Main{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    int om = m;
	    if(n==0 && m==0)break;
	    if(m>n-m)m=n-m;
	    long ans = 1;
	    for(int i = 0;i < m;i++){
		ans = ans * (n-i) / (i+1);
	    }
	    System.out.println(n + " things taken " + om + " at a time is " + ans + " exactly.");
	}
    }
}
