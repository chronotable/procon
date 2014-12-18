import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	final int INF = Integer.MAX_VALUE;
	Scanner sc = new Scanner(System.in);
	for(int o = sc.nextInt(); o > 0; o--){
	    int iw = sc.nextInt();
	    int cw = sc.nextInt();
	    int w = cw - iw;
	    int n = sc.nextInt();
	    int[] dp = new int[w+1];
	    Arrays.fill(dp, INF);
	    dp[0] = 0;
	    for(int i = 0; i < n; i++){
		int p = sc.nextInt();
		int q = sc.nextInt();
		for(int j = 0; j <= w - q; j++){
		    if(dp[j] == INF)continue;
		    dp[j+q] = min(dp[j+q], dp[j] + p);
		}
	    }
	    if(dp[w] == INF)
		System.out.println("This is impossible.");
	    else
		System.out.printf("The minimum amount of money in the piggy-bank is %d.\n", dp[w]);
	}
    }
}