// SRM 487 div2 medium, div1 easy
import java.util.*;
import static java.lang.Math.*;

public class BunnyComputer{
    int dp(int[] a){
        int n = a.length;
        int[] d = new int[n];
        for(int i = 0; i < n - 1; i++){
            int mx = 0;
            for(int j = 0; j < i; j++)mx = max(mx, d[j]);
            d[i+1] = mx + a[i] + a[i+1];
        }
        int ret = 0;
        for(int i = 0; i < d.length; i++)ret = max(ret, d[i]);
        return ret;
    }
    public int getMaximum(final int[] p, final int k){
        int n = p.length;
        int res = 0;
        for(int i = 0; i <= k; i++){
            ArrayList<Integer> a = new ArrayList<Integer>();
            for(int j = i; j < n; j += k + 1)a.add(p[j]);
            int m = a.size();
            int[] b = new int[m];
            for(int j = 0; j < m; j++)b[j] = a.get(j);
            res += dp(b);
        }
        return res;
    }
}

