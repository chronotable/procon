import java.util.*;
import static java.lang.Math.*;

public class RandomPancakeStack{
    public double expectedDeliciousness(int[] d){
        int n = d.length;
        if(n == 1)return d[0];
        double[][] dp = new double[n][n];
        double ans = 0;
        for(int i = 0; i < n; i++){
            dp[0][i] = 1.0 / n;
            ans += d[i] * dp[0][i];
        }
        for(int t = 1; t < n; t++){
            int r = n - t;
            for(int i = 0; i < n; i++)if(dp[t-1][i] > 0){
                    for(int j = 0; j < i; j++){
                        dp[t][j] += dp[t-1][i] / r;
                        ans += d[j] * dp[t-1][i] / r;
                    }
                }
        }
        return ans;
    }
}
