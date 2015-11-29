import java.util.*;
import static java.lang.Math.*;

public class MissingLCM{
    public int getMin(int N){
        if(N == 1)return 2;
        boolean[] u = new boolean[N+1];
        int ans = N;
        for(int i = 2; i <= N; i++)if(!u[i]){
                for(int j = i+i; j <= N; j += i)u[j] = true;
                long s = i;
                while(s <= N)s *= i;
                s /= i;
                int r = (int)s;
                int t = (N + r) / r;
                ans = max(ans, t * r);
            }
        return ans;
    }
}
