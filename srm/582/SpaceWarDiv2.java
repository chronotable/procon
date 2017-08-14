import java.util.*;
import static java.lang.Math.*;

public class SpaceWarDiv2{
    public int minimalFatigue(int[] mgs, int[] es, int[] ec){
        int n = mgs.length;
        int m = es.length;
        final int BASE = 1000;
        int INF = 1<<20;
        int left = 0, right = INF;
        Arrays.sort(mgs);
        while(left <= right){
            int mid = (left + right) / 2;
            int[] ee = new int[m];
            for(int i = 0; i < m; i++)ee[i] = es[i] * BASE + ec[i];
            Arrays.sort(ee);
            int cur = n-1;
            int rest = mid;
            boolean ok = true;
            loop:
            for(int i = m - 1; i >= 0; i--){
                int s = ee[i] / BASE;
                int c = ee[i] % BASE;
                while(c > 0 && cur >= 0){
                    if(mgs[cur] < s){
                        ok = false;
                        break loop;
                    }
                    int need = min(c, rest);
                    c -= need;
                    rest -= need;
                    if(rest == 0){
                        cur--;
                        rest = mid;
                    }
                }
                if(c > 0){
                    ok = false;
                    break loop;
                }
            }
            if(ok)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left > INF ? -1 : left;
    }
}
