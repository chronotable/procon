import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int n = sc.nextInt();
            if(n < 0)break;
            int[][] b = new int[n][n];
            for(int i = 0; i < n; i++){
                String s = sc.next();
                for(int j = 0; j < n; j++)
                    b[i][j] = s.charAt(j) - '0';
            }
            long[][] dp = new long[n][n];
            dp[0][0] = 1;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    for(int k = 0; k < i; k++)
                        if(b[k][j] == i - k)dp[i][j] += dp[k][j];
                    for(int k = 0; k < j; k++)
                        if(b[i][k] == j - k)dp[i][j] += dp[i][k];
                }
            }
            System.out.println(dp[n-1][n-1]);
        }
    }
}
