import java.util.*;
import static java.lang.Math.*;

public class BearFair{
    public String isFair(int n, int b, int[] u, int[] q){
        int m = u.length;
        ArrayList<Bound> a = new ArrayList<Bound>();
        for(int i = 0; i < m; i++)a.add(new Bound(u[i], q[i]));
        Collections.sort(a);
        for(int i = 0; i < m - 1; i++){
            Bound b0 = a.get(i), b1 = a.get(i+1);
            if(b0.u == b1.u && b0.q != b1.q)return "unfair";
            if(b0.q > b1.q)return "unfair";
        }
        boolean[][][] dp = new boolean[b+1][n+1][n+1];
        int[] norma = new int[b+1];
        Arrays.fill(norma, -1);
        for(int i = 0; i < m; i++)norma[u[i]] = q[i];
        dp[0][0][0] = true;
        for(int i = 0; i < b; i++)for(int even = 0; even < n; even++)for(int odd = 0; odd < n; odd++)if(dp[i][even][odd]){
                        if((i+1) % 2 == 0){
                            if(norma[i+1] >= 0){
                                if(even + odd == norma[i+1])dp[i+1][even][odd] = true;
                                if(even + 1 + odd == norma[i+1])dp[i+1][even+1][odd] = true;
                            }else{
                                dp[i+1][even][odd] = true;
                                dp[i+1][even+1][odd] = true;
                            }
                        }else{
                            if(norma[i+1] >= 0){
                                if(even + odd == norma[i+1])dp[i+1][even][odd] = true;
                                if(even + odd + 1 == norma[i+1])dp[i+1][even][odd+1] = true;
                            }else{
                                dp[i+1][even][odd] = true;
                                dp[i+1][even][odd+1] = true;
                            }
                        }
                    }
        return dp[b][n/2][n/2] ? "fair" : "unfair";
    }
}
class Bound implements Comparable<Bound>{
    int u;
    int q;
    Bound(int _u, int _q){
        u = _u;
        q = _q;
    }
    public int compareTo(Bound b){
        if(u != b.u)return u - b.u;
        return q - b.q;
    }
}
