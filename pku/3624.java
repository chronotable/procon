import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] d = new int[n];
        for(int i = 0; i < n;i++){
            w[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        int[] dp = new int[m+1];
        int[] next = new int[m+1];
        for(int i = 0; i < n;i++){
            for(int j = 0; j < w[i];j++)next[j] = dp[j];
            for(int j = w[i];j < dp.length;j++){
                next[j] = max(dp[j], dp[j - w[i]] + d[i]);
            }
            dp = next;
            next = new int[m+1];
        }
        int ans = 0;
        for(int i = 0; i < dp.length;i++)ans = max(ans, dp[i]);
        System.out.println(ans);
    }
}
