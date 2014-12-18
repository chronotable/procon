import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int m = sc.nextInt();
            int n = sc.nextInt();
            if(m + n == 0)break;
            int[] lst = new int[m+1];
            for(int i = 1; i <= m; i++)lst[i] = sc.nextInt();
            int[] id = new int[n+1];
            double[] price = new double[n+1];
            for(int i = 1; i<= n;i++){
                id[i] = sc.nextInt();
                price[i] = sc.nextDouble();
            }
            double[] dp = new double[m+1];
            final double M = 1e20;
            Arrays.fill(dp, M);
            dp[0] = 0;
            for(int i = 1; i<= n;i++){
                double[] next = new double[m+1];
                Arrays.fill(next, M);
                next[0] = 0;
                for(int j = 1; j <= m; j++){
                    if(id[i] == lst[j]){
                        next[j] = min(dp[j], dp[j-1] + price[i]);
                    }else{
                        next[j] = dp[j];
                    }
                }
                dp = next;
            }
            if(dp[m] == M)System.out.println("Impossible");
            else System.out.printf("%.2f\n", dp[m]);
        }
    }
}
