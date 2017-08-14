import java.util.*;
import static java.lang.Math.*;

public class PiecewiseLinearFunctionDiv2{
    public int[] countSolutions(int[] y, int[] q){
        int p = y.length;
        int n = q.length;
        int[] ret = new int[n];
        for(int i = 0; i < n; i++){
            int count = 0;
            int r = q[i];
            for(int j = 1; j < p; j++){
                if(y[j-1] == y[j]){
                    if(r == y[j]){count = -1; break;}
                }else{
                    int mx = max(y[j-1], y[j]);
                    int mn = min(y[j-1], y[j]);
                    if(mn <= r && r <= mx && r != y[j])count++;
                }
            }
            if(count >= 0 && y[p-1] == r)count++;
            ret[i] = count;
        }
        return ret;
    }
}
