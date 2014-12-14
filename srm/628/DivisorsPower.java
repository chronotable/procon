import java.util.*;
import static java.lang.Math.*;

public class DivisorsPower{
    boolean isp(long n){
        if(n == 1)return false;
        int lim = (int)sqrt(n);
        for(int i = 2; i <= lim; i++)if(n % i == 0)return false;
        return true;
    }
    int d(int n){
        int ret = 0;
        for(int i = 1; i <= n; i++)if(n % i == 0)ret++;
        return ret;
    }
    public long findArgument(long n){
        long ans = Long.MAX_VALUE;
        long m = (long)sqrt(n);
        if(m * m == n && isp(m))ans = m;
        for(int i = 3; ; i++){
            double sq = pow(n, 1.0/i);
            if(sq < 2.0)break;
            int s = (int)sq;
            for(int j = s; j <= s+1; j++){
                long v = 1;
                for(int k = 0; k < i; k++)v *= j;
                if(v == n){
                    if(d(j) == i)ans = min(ans, j);
                }
            }
        }
        if(ans == Long.MAX_VALUE)return -1;
        return ans;
    }
}
