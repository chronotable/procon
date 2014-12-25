import java.util.*;
import static java.lang.Math.*;

public class PalindromicSubstringsDiv1{
    int n;
    char[] s;
    double[][] dp;
    public double expectedPalindromes(String[] S1, String[] S2){
        StringBuilder sb = new StringBuilder("");
        for(String s : S1)sb.append(s);
        for(String s : S2)sb.append(s);
        s = sb.toString().toCharArray();
        n = s.length;
        dp = new double[n][n];
        double ans = n;
        for(int i = 0; i < n; i++)dp[i][i] = 1;
        for(int i = 1; i < n; i++)dp[i][i-1] = 1;
        for(int len = 2; len <= n; len++){
            for(int i = 0; i < n; i++){
                int j = i+len-1;
                if(j >= n)break;
                //if(s[i] == '?' && s[j] == '?')
                //  dp[i][j] = dp[i+1][j-1];
                if(s[i] == '?' || s[j] == '?')
                    dp[i][j] = dp[i+1][j-1] / 26;
                else if(s[i] == s[j])
                    dp[i][j] = dp[i+1][j-1];
                //System.out.printf("dp[%d][%d]=%.6f", i, j, dp[i][j]);System.out.println();
                ans += dp[i][j];
            }
        }
        return ans;
    }
}