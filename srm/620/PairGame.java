import java.util.*;
import static java.lang.Math.*;

public class PairGame{
    public int maxSum(int a, int b, int c, int d){
        final long B = 1000001;
        HashSet<Long> tbl = new HashSet<Long>();
        while(a > 0 && b > 0){
            tbl.add(a*B + b);
            if(a > b)a -= b;
            else if(a < b)b -= a;
            else break;
        }
        int ans = -1;
        while(c > 0 && d > 0){
            long key = c * B + d;
            if(tbl.contains(key))ans = max(ans, c+d);
            if(c > d)c -= d;
            else if(c < d)d -= c;
            else break;
        }
        return ans;
    }
}