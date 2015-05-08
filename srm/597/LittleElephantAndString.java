import java.util.*;
import static java.lang.Math.*;

public class LittleElephantAndString{
    boolean can(String A, String B){
        char[] a = A.toCharArray(); Arrays.sort(a);
        char[] b = B.toCharArray(); Arrays.sort(b);
        int n = a.length;
        for(int i = 0; i < n; i++)if(a[i] != b[i])return false;
        return true;
    }
    public int getNumber(String A, String B){
        int n = A.length();
        if(!can(A, B))return -1;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int cur = n-1;
        for(int i = n-1; i >= 0; i--){
            if(b[cur] == a[i])cur--;
        }
        return cur+1;
        /*
    int[][] dp = new int[n+1][n+1];
    for(int i = 1; i <= n; i++)for(int j = 1; j <= n; j++){
      dp[i][j] = max(dp[i-1][j-1]+(a[i-1]==b[j-1]?1:0), max(dp[i-1][j], dp[i][j-1]));
    }
    return n - dp[n][n];
        */
    }
}
