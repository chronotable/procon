import java.util.*;
import static java.lang.Math.*;

public class BearCavalry{
    private static final  int MOD = 1000000007;
    long calc(int[] w, int[] h, final int limit){
        int m = w.length;
        Arrays.sort(w);
        Arrays.sort(h);
        long ret = 1;
        for(int i = m-1; i >= 0; i--){
            int del = m-1-i;
            int count = 0;
            for(int j = 0; j < m; j++)if(w[i] * h[j] < limit)count++;
            if(count - del <= 0)return 0;
            ret *= count - del;
            ret %= MOD;
        }
        return ret;
    }
    public int countAssignments(int[] w, int[] h){
        int n = w.length;
        long ans = 0;
        for(int i = 0; i < n; i++){
            int limit = w[0] * h[i];
            int[] rw = new int[n-1];
            for(int j = 1; j < n; j++)rw[j-1] = w[j];
            int[] rh = new int[n-1];
            int count = 0;
            for(int j = 0; j < n; j++)if(i != j)rh[count++] = h[j];
            ans += calc(rw, rh, limit);
            ans %= MOD;
        }
        return (int)(ans % MOD);
    }
}
