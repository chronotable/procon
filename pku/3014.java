import java.util.*;
import static java.lang.Math.*;

public class Main{
    static int[][] dp = new int[4501][4501];
    static final int MOD = 1000000007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0; i < dp.length;i++){
            dp[i][0] = 0;
            dp[0][i] = 1;
        }
        dp[0][0] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i >= j)
                    dp[i][j]=(dp[i][j-1]+dp[i-j][j])%MOD;
                else
                    dp[i][j]=dp[i][j-1];
            }
        }
        System.out.println(dp[m][n]);
    }
}
