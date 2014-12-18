import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        BigInteger[] dp = new BigInteger[201];
        dp[0] = new BigInteger("1");
        dp[2] = new BigInteger("1");
        for(int i = 4; i <= 200; i+=2){
            dp[i] = new BigInteger("0");
            int rest = i - 2;
            for(int j = 0; j <= rest; j += 2)
                dp[i] = dp[i].add(dp[j].multiply(dp[rest-j]));
        }
        Scanner sc = new Scanner(System.in);
        for(;;){
            int n = sc.nextInt();
            if(n < 0)break;
            System.out.println(dp[n*2]);
        }
    }
}
