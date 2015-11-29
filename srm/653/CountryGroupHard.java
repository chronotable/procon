import java.util.*;
import static java.lang.Math.*;

public class CountryGroupHard{
    private static final int MOD = 1000000007;
    int n;
    int[] a;
    long[][] dp;
    long possible(int left, int right){
        if(left>right)return 1;
        if(dp[left][right] >= 0)return dp[left][right];
        long ways = 0;
        int m = right - left + 1;
        for(int i = left; i <= left; i++){
            for(int t = 1; t <= m; t++){
                if(i + t > right + 1)continue;
                if(a[i] != 0 && a[i] != t)continue;
                boolean f = true;
                for(int j = i; j < i + t; j++)if(a[j] != t && a[j] != 0)f = false;
                if(f)ways = (long)((ways + possible(left, i-1) * possible(i+t, right)) % MOD);
            }
        }
        //System.out.println(left + " " + right + "=" + ways);
        dp[left][right] = ways;
        return dp[left][right];
    }
    public String solve(int[] _a){
        a = _a;
        n = a.length;
        dp = new long[n][n];
        for(int i = 0; i < n; i++)Arrays.fill(dp[i], -1);
        return possible(0, n-1) == 1 ? "Sufficient" : "Insufficient";
    }
}
