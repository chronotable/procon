import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[10001];
        int count = 1;
        loop:
        for(int i = 1;;i++){
            for(int j = 0; j < i;j++){
                dp[count] = dp[count-1] + i;
                count++;
                if(count > 10000)break loop;
            }
        }
        for(;;){
            int n = sc.nextInt();
            if(n==0)break;
            System.out.printf("%d %d\n", n, dp[n]);
        }
    }
}
