import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int m = sc.nextInt();
	for(;m>0;m--){
	    int n = sc.nextInt();
	    int[][] d = new int[n][n];
	    for(int i = 0; i < n-1;i++){
		for(int j = i+1;j<n;j++){
		    d[i][j]=d[j][i]=sc.nextInt();
		}
	    }
	    int[][][] dp = new int[n][n][n];
	    for(int i = 0; i < n;i++)
		for(int j = 0; j < n;j++)
		    Arrays.fill(dp[i][j],Integer.MAX_VALUE);
	    dp[0][0][0] = 0;
	    for(int i = 0; i < n-1;i++){
		for(int j = 0; j <= i;j++){
		    for(int k = 0; k <= i;k++){
			if(dp[i][j][k]==Integer.MAX_VALUE)continue;
			dp[i+1][j][k]=min(dp[i+1][j][k],dp[i][j][k]+d[i][i+1]);
			dp[i+1][i][j]=min(dp[i+1][i][j],dp[i][j][k]+d[k][i+1]);
			dp[i+1][i][k]=min(dp[i+1][i][k],dp[i][j][k]+d[j][i+1]);
		    }
		}
	    }
	    int ans=Integer.MAX_VALUE;
	    for(int i = 0; i < n;i++)
		for(int j = 0; j < n;j++)
		    ans = min(ans,dp[n-1][i][j]);
	    System.out.println(ans);
	}
    }
}