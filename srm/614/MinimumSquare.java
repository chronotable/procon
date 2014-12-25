import java.util.*;
import static java.lang.Math.*;

public class MinimumSquare{
    public long minArea(int[] x, int[] y, int K){
        int n = x.length;
        long ans = Long.MAX_VALUE;
        int[] lens = new int[n];
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++){
                int sum = 0;
                for(int k = 0; k < n; k++)if(x[i] <= x[k] && y[j] <= y[k])
                                              lens[sum++] = max(x[k] - x[i], y[k] - y[j]);
                if(sum >= K){
                    Arrays.sort(lens, 0, sum);
                    int len = lens[K-1] + 2;
                    ans = min(ans, 1l * len * len);
                }
            }
        return ans;
    }
}