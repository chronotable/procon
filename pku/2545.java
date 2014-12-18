import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int p1 = sc.nextInt(), p2 = sc.nextInt(), p3 = sc.nextInt();
	int n = sc.nextInt();
	long[] dp = new long[10000];
	int r=0,s=0,t=0;
	dp[0]=1;
	long ans=0;
	for(int i = 1; i <= n;i++){
	    ans = min(dp[r]*p1,min(dp[s]*p2,dp[t]*p3));
	    dp[i]=ans;
	    if(ans==dp[r]*p1)r++;
	    if(ans==dp[s]*p2)s++;
	    if(ans==dp[t]*p3)t++;
	}
	System.out.println(ans);
    }
}
