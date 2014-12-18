import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int[] dp = new int[1001];
        dp[1] = 3;
        for(int i = 2; i < dp.length; i++){
            int sum = 0;
            for(int j = 1; j < i; j++)
                if(gcd(i, j) == 1)sum++;
            sum *= 2;
            dp[i] = sum + dp[i-1];
        }
        for(int o = 1; o <= c; o++){
            int n = sc.nextInt();
            System.out.printf("%d %d %d\n", o, n, dp[n]);
        }
    }

    static int gcd(int a, int b){
        if(b>a)return gcd(b,a);
        if(a % b == 0) return b;
        return gcd(b, a%b);
    }
}
