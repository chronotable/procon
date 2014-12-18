import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int n = sc.nextInt();
	    if(n==-1)break;
	    long ans = 4;
	    ans += 6 * ((long)pow(2,n) - 2);
	    long[][] dp = new long[n][4];
	    Arrays.fill(dp[0],1);
	    for(int i = 1; i < n;i++){
		for(int j = 0; j < 4;j++){
		    for(int k = 0; k < 4;k++){
			if(abs(j-k)!=3)dp[i][j] += dp[i-1][k];
		    }
		}
	    }
	    for(int i = 0; i < 4;i++)ans+=dp[n-1][i];
	    ans -= 4;
	    ans -= 5 * ((long)pow(2,n) - 2);
	    ans = (long)pow(4,n) - ans;
	    System.out.println(n + ": " + ans);
	}
    }
}