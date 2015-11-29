import java.util.*;
import static java.lang.Math.*;

public class BearCries{
    private static final int MOD = 1000000007;
    long[][][] dp = new long[201][200][200];
    public int count(String message){
        char[] m = message.toCharArray();
        int n = m.length;
        dp[0][0][0] = 1; // pos, # of opening emoticons without _s, # of opening emoticons with _s
        for(int i = 0; i < n; i++)for(int y = 0; y < 200; y++)for(int x = 0; x < 200; x++)if(dp[i][y][x] > 0){
                        long d = dp[i][y][x];
                        if(m[i] == '_'){
                            if(y > 0){
                                dp[i+1][y-1][x+1] += d*y;
                                dp[i+1][y-1][x+1] %= MOD;
                            }
                            if(x > 0){
                                dp[i+1][y][x] += d*x;
                                dp[i+1][y][x] %= MOD;
                            }
                        }else{
                            if(x > 0){
                                dp[i+1][y][x-1] += d*x;
                                dp[i+1][y][x-1] %= MOD;
                            }
                            dp[i+1][y+1][x] += d;
                            dp[i+1][y+1][x] %= MOD;
                        }
                    }
        return (int)dp[n][0][0];
    }
}
