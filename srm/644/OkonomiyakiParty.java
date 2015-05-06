import java.util.*;
import static java.lang.Math.*;

public class OkonomiyakiParty{
    public int count(int[] osize, int M, int K){
        int n = osize.length;
        Arrays.sort(osize);
        final int MOD = 1000000007;
        long[][] dp = new long[M+1][10001];
        for(int i = 0; i <= M; i++)Arrays.fill(dp[i], -1);
        for(int o = 0; o < n; o++){
            int a = osize[o];
            long[][] next = new long[M+1][10001];
            for(int i = 0; i <= M; i++)for(int j = 0; j <= 10000; j++)next[i][j] = dp[i][j];
            for(int i = 0; i < M; i++)for(int j = 0; j <= 10000; j++)if(dp[i][j] >= 0){
                        if(j + K < a)continue;
                        int mn = min(j, a);
                        if(next[i+1][mn] < 0)next[i+1][mn] = 0;
                        next[i+1][mn] += dp[i][j];
                        //if(i == 0)next[i+1][mn] += 1;
                        if(next[i+1][mn] >= MOD)next[i+1][mn] -= MOD;
                    }
            if(next[1][a] < 0)next[1][a] = 0;
            next[1][a]++; next[1][a] %= MOD;
            dp = next;
        }
        int ans = 0;
        for(int i = 0; i <= 10000; i++)if(dp[M][i] >= 0){
                //System.out.println("dp[" + M + "][" + i + "]=" + dp[M][i]);
                ans += dp[M][i];
                ans %= MOD;
            }
        return ans;
    }
}
