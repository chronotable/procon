import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger[] dp = new BigInteger[1001];
        dp[1] = new BigInteger("0");
        dp[2] = new BigInteger(""+1);
        dp[3] = new BigInteger(""+1);
        BigInteger bp = new BigInteger(""+2);
        for(int i = 4; i < 1001;i++){
            dp[i] = dp[i-2].add(bp);
            bp = bp.multiply(new BigInteger("2"));
        }
        for(;sc.hasNext();){
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}