import java.util.*;
import static java.lang.Math.*;

public class TaroFriends{
    public int getNumber(int[] c, int x){
        int n = c.length;
        Arrays.sort(c);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int a = 0; a < 2; a++){
                int base = c[i] + (a==0?x:-x);
                int mn = base, mx = base;
                for(int j = 0; j < n; j++)if(j != i){
                        int next = c[j];
                        if(next < base)next+=x;
                        else next-=x;
                        mn = min(mn, next);
                        mx = max(mx, next);
                    }
                ans = min(ans, mx-mn);
            }
        }
        return ans;
    }
}