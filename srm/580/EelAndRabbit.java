import java.util.*;
import static java.lang.Math.*;

public class EelAndRabbit{
    int get(int[] l, int[] t, int a, int b){
        final int n = l.length;
        boolean[] u = new boolean[n];
        for(int i = 0; i < n; i++)if((t[i] <= a && a <= t[i] + l[i]) || (t[i] <= b && b <= t[i] + l[i]))u[i] = true;
        int ret = 0;
        for(int i = 0; i < n; i++)if(u[i])ret++;
        return ret;
    }
    public int getmax(int[] l, int[] t){
        final int n = l.length;
        if(n <= 2)return n;
        int ans = 0;
        for(int i = 0; i < n; i++)for(int j = i+1; j < n; j++){
                ans = max(ans, get(l, t, t[i], t[j]));
                ans = max(ans, get(l, t, t[i] + l[i], t[j]));
                ans = max(ans, get(l, t, t[i], t[j] + l[j]));
                ans = max(ans, get(l, t, t[i] + l[i], t[j] + l[j]));
            }
        return ans;
    }
}
