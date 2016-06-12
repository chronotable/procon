import java.util.*;
import static java.lang.Math.*;

public class BracketSequenceDiv1{
    int n;
    char[] s;
    long[][] dp;
    long calc(int left, int right){
        if(left >= right)return 1;
        if(dp[left][right] >= 0)return dp[left][right];
        dp[left][right] = calc(left+1, right);
        for(int i = left+1; i <= right; i++)
            if((s[left] == '(' && s[i] == ')') || (s[left] == '[' && s[i] == ']'))
                dp[left][right] += calc(left+1, i-1) * calc(i+1, right);
        return dp[left][right];
    }
    public long count(String S){
        n = S.length();
        s = S.toCharArray();
        dp = new long[n][n];
        for(int i = 0; i < n; i++)Arrays.fill(dp[i], -1);
        return calc(0, n-1) - 1;
    }
}
