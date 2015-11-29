import java.util.*;
import static java.lang.Math.*;

public class ThePermutationGame{
    public int findMin(int N){
        final int MOD = 1000000007;
        long ans = 1;
        boolean[] u = new boolean[N+1];
        for(int i = 2; i <= N; i++)if(!u[i]){
                long t = i;
                while(t <= N)t *= i;
                t /= i;
                ans *= t;
                ans %= MOD;
                for(int j = i*2; j <= N; j += i)u[j] = true;
            }
        return (int)ans;
    }
}
