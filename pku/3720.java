import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] dp = new int[101][10];
        for(int i = 2; i <= 100;i++){
            int[] count = new int[10];
            boolean[] u = new boolean[i];
            u[1] = true;
            int cur = 1;
            while(true){
                cur *= 10;
                int div = cur / i;
                int mod = cur % i;
                count[div]++;
                if(mod == 0 || u[mod])break;
                u[mod] = true;
                cur = mod;
            }
            for(int j = 0; j < 10;j++)dp[i][j] = dp[i-1][j] + count[j];
        }
        for(;sc.hasNext();){
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(dp[n][k]);
        }
    }
}
