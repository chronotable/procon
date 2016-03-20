import java.util.*;
import static java.lang.Math.*;

public class TimeTravellingCellar{
    public int determineProfit(int[] p, int[] d){
        int ans = - 1000000;
        int n = p.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i!=j)ans = max(ans, p[i] - d[j]);
            }
        }
        return ans;
    }
}