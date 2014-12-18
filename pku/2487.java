
import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int c = sc.nextInt();
	for(int o = 1; o <= c;o++){
	    int r = sc.nextInt();
	    int n = sc.nextInt();
	    int[] s = new int[n];
	    for(int i = 0; i < n;i++)s[i] = sc.nextInt();
	    Arrays.sort(s);
	    int sum = 0;
	    int ans;
	    for(ans = n-1;ans >= 0;ans--){
		sum += s[ans];
		if(sum>=r)break;
	    }
	    System.out.println("Scenario #" + o + ":");
	    if(ans<0)System.out.println("impossible");
	    else System.out.println(n-ans);
	    System.out.println();
	}
    }
}
