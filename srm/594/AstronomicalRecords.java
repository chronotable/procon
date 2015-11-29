import java.util.*;
import static java.lang.Math.*;

public class AstronomicalRecords{
    int dp(int[] a, int as, int ae, int av, int[] b, int bs, int be, int bv){
        int an = ae - as + 1, bn = be - bs + 1;
        int[][] dp = new int[an+1][bn+1];
        for(int i = 1; i <= an; i++)for(int j = 1; j <= bn; j++){
                long s = 1l * a[as+i-1] * bv;
                long t = 1l * b[bs+j-1] * av;
                int v = (s==t?1:0);
                dp[i][j] = max(dp[i-1][j-1] + v, max(dp[i-1][j], dp[i][j-1]));
            }
        return an + bn - dp[an][bn];
    }
    int match(int[] a, int ai, int[] b, int bi){
        return 1 + dp(a, 0, ai-1, a[ai], b, 0, bi-1, b[bi]) + dp(a, ai+1, a.length-1, a[ai], b, bi+1, b.length-1, b[bi]);
    }
    public int minimalPlanets(int[] a, int[] b){
        int x = a.length;
        int y = b.length;
        int ans = x+y-1;
        for(int i = 0; i < x; i++)for(int j = 0; j < y; j++)
                                      ans = min(ans, match(a, i, b, j));
        return ans;
    }
}