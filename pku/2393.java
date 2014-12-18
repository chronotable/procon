import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        int[] c = new int[n];
        int[] y = new int[n];
        for(int i = 0; i < n;i++){
            c[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        for(int i = 0; i < n;i++){
            dp[i] = min(dp[i], c[i] * y[i]);
            for(int j = i+1; j < n;j++){
                int cost = c[i] + s * (j-i);
                if(cost >= c[j])continue;
                long v = 1l * cost * y[j];
                dp[j] = min(dp[j], v);
            }
        }
        long ans = 0;
        for(int i = 0; i < n;i++){ans += dp[i];}
        System.out.println(ans);
    }
}