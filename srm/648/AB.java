import java.util.*;
import static java.lang.Math.*;

public class AB{
    final String NG = "N";
    String[][][] dp;
    String calc(int len, int a, int pair){
        if(dp[len][a][pair] != null)return dp[len][a][pair];
        if(len==0){
            if(pair == 0)return "";
            else return NG;
        }
        //String ret = NG;
        // B
        if(pair - a >= 0){
            String bs = calc(len-1, a, pair-a);
            if(!bs.equals(NG)){
                dp[len][a][pair] = "B" + bs;
                return dp[len][a][pair];
            }
        }
        // A
        String as = calc(len-1, a+1, pair);
        if(!as.equals(NG)){
            dp[len][a][pair] = "A" + as;
            return dp[len][a][pair];
        }
        dp[len][a][pair] = NG;
        return NG;
    }
    public String createString(int N, int K){
        dp = new String[N+1][N+1][K+1];
        String ans =  calc(N, 0, K);
        if(ans.equals(NG))return "";
        return ans;
    }
}
