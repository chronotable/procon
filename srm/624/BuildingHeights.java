import java.util.*;
import static java.lang.Math.*;

public class BuildingHeights{
    public int minimum(int[] h){
        int n = h.length;
        int ans = 0;
        Arrays.sort(h);
        for(int i = 2; i <= n; i++){
            int mn = 1<<30;
            int sum = 0;
            for(int j = 0; j < i-1; j++)sum += h[j];
            for(int j = i-1; j < n; j++){
                sum += h[j];
                int need = h[j] * i;
                mn = min(mn, need - sum);
                sum -= h[j-i+1];
            }
            ans ^= mn;
        }
        return ans;
    }
}
