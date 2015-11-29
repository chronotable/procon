import java.util.*;
import static java.lang.Math.*;

public class OrderOfOperations{
    private static final int INF = 1<<20;
    public int minTime(String[] s){
        final int n = s.length;
        final int m = s[0].length();
        int[] t = new int[n];
        for(int i = 0; i < n; i++)for(int j = 0; j < m; j++)if(s[i].charAt(j)=='1')t[i] |= 1<<j;
        final int limit = 1<<m;
        int[] dp = new int[limit];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int i = 0; i < limit; i++)if(dp[i] != INF){
                //System.out.println(i + "=" + dp[i]);
                for(int j = 0; j < n; j++){
                    int k = i | t[j];
                    if(k == i)continue;
                    int bc = Integer.bitCount(k ^ i);
                    dp[k] = min(dp[k], dp[i] + bc * bc);
                }
            }
        int last = 0;
        for(int i = 0; i < n; i++)last |= t[i];
        return dp[last];
    }
}
