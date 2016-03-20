import java.util.*;
import static java.lang.Math.*;

public class VampireTree{
    int n;
    int[] num;
    int lim;
    int dp[][];
    int calc(int one, int mask){
        if(mask + 1 == lim)return one == 0 ? 0 : -1;
        if(dp[one][mask] > -2)return dp[one][mask];
        final int bc = Integer.bitCount(mask);
        if(bc == n-1){
            int rest = 0;
            for(int i = 0; i < n; i++)if( (int)((mask >> i) & 1) == 0){rest = num[i]; break;}
            return rest == one ? (rest > 1 ? 1 : 0) : -1;
        }
        int ret = -1;
        for(int i = 0; i < n; i++)if( (int)((mask >> i) & 1) == 0 && one >= num[i] - 1){
                int r = calc(one - num[i] + 2, mask | (1<<i));
                if(r >= 0)ret = max(ret, r + 1);
            }
        return dp[one][mask] = ret;
    }
    public int maxDistance(int[] _num){
        num = _num;
        n = num.length;
        if(n == 2)return num[0] + num[1] == 2 ? 1 : -1;
        lim = 1<<n;
        dp = new int[n][lim];
        for(int i = 0; i < n; i++)Arrays.fill(dp[i], -2);
        Arrays.sort(num);
        int one = 0;
        int mask = 0;
        for(int i = 0; i < n; i++)if(num[i] == 1){one++; mask |= 1<<i;}
        int ret = calc(one, mask);
        if(ret == -1)return -1;
        return max(ret + 1, 2);
    }
}
