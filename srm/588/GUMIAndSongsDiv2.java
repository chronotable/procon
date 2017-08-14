import java.util.*;
import static java.lang.Math.*;

public class GUMIAndSongsDiv2{
    public int maxSongs(int[] d, int[] t, int T){
        final int INF = 1<<30;
        int n = d.length;
        int lim = 1<<n;
        int[][] dp = new int[n][lim];
        for(int i = 0; i < n; i++){Arrays.fill(dp[i], INF); dp[i][1<<i] = d[i];}
        int ans = 0;
        for(int m = 1; m < lim; m++)for(int i = 0; i < n; i++)if(dp[i][m] < INF){
                    int b = Integer.bitCount(m);
                    if(dp[i][m] <= T)ans = max(ans, b);
                    for(int j = 0; j < n; j++)if((int)((m>>j)&1) == 0){
                            int a = m | (1<<j);
                            dp[j][a] = min(dp[j][a], dp[i][m] + d[j] + abs(t[i] - t[j]));
                        }
                }
        return ans;
    }
}
