import java.util.*;
import static java.lang.Math.*;

public class SimilarRatingGraph{
    public double maxLength(int[] d, int[] r){
        int n = d.length;
        double[] len = new double[n];
        for(int i = 1; i < n; i++)len[i] = len[i-1] + hypot(d[i] - d[i-1], r[i] - r[i-1]);
        double ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)if(i != j){
                    boolean ok = true;
                    if(j+1 >= n || i+1 >= n)continue;
                    double ratio = 1.0 * (d[j+1] - d[j]) / (d[i+1] - d[i]);
                    int k = 1;
                    for(; i+k < n && j+k < n; k++){
                        if(abs((d[j+k] - d[j+k-1]) - ratio * (d[i+k] - d[i+k-1])) > 1e-11 ||
                           abs((r[j+k] - r[j+k-1]) - ratio * (r[i+k] - r[i+k-1])) > 1e-11){
                            break;
                        }
                    }
                    k--;
                    ans = max(ans, len[i+k] - len[i]);
                }
        }
        return ans;
    }
}
