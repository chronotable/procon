import java.util.*;
import static java.lang.Math.*;

// TLE
public class SquareScores{
    public double calcexpectation(int[] P, String S){
        int n = S.length();
        int t = P.length;
        char[] s = S.toCharArray();
        double[] p = new double[t];
        for(int i = 0; i < t; i++)p[i] = P[i] / 100.0;
        double[] r = new double[n+1];
        for(int i = 1; i <= n; i++)r[i] = i * (i+1) / 2.0;
        double ans = 0;
        double[][] dp = new double[n+1][t];
        if(s[0] == '?'){
            for(int i = 0; i < t; i++)dp[1][i] = p[i];
        }else{
            dp[1][s[0]-'a'] = 1;
        }
        for(int i = 1; i < n; i++){
            double[][] next = new double[n+1][t];
            if(s[i] == '?'){
                for(int c = 0; c < t; c++){
                    for(int j = 1; j <= n; j++)for(int k = 0; k < t; k++)if(dp[j][k] > 0){
                                if(k == c){
                                    next[j+1][k] += dp[j][k] * p[c];
                                }else{
                                    ans += r[j] * dp[j][k] * p[c];
                                    next[1][c] += dp[j][k] * p[c];
                                }
                            }
                }
            }else{
                int c = s[i] - 'a';
                for(int j = 1; j <= n; j++)for(int k = 0; k < t; k++)if(dp[j][k] > 0){
                            if(k == c){
                                next[j+1][k] += dp[j][k];
                            }else{
                                ans += r[j] * dp[j][k];
                                next[1][c] += dp[j][k];
                            }
                        }
            }
            dp = next;
        }
        for(int i = 1; i <= n; i++)for(int j = 0; j < t; j++)ans += r[i] * dp[i][j];
        return ans;
    }
}
