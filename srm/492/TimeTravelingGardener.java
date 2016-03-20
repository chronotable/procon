import java.util.*;
import static java.lang.Math.*;

public class TimeTravellingGardener{
    public int determineUsage(int[] d, int[] y){
        int n = y.length;
        int[] x = new int[n];
        x[0] = 0;
        for(int i = 0; i < n-1; i++)x[i+1] = x[i] + d[i];
        int ans = n-1;
        for(int i = 0; i < n; i++)for(int j = i+1; j < n; j++){
                final int dx = x[j] - x[i];
                final int dy = y[j] - y[i];
                final double a = 1.0 * dy / dx;
                final double b = y[i] - x[i] * a;
                boolean ok = true;
                int sum = 0;
                for(int k = 0; k < n; k++)if(k != i && k != j){
                        if(y[k] + 1e-9 < a * x[k] + b || a * x[k] + b < -1e-9)ok = false;
                        int ex = x[j] - x[k];
                        int ey = y[j] - y[k];
                        if(k > j){
                            ex = -ex; ey = -ey;
                        }
                        if(dx * ey != ex * dy)sum++;
                    }
                //System.out.println(i + " " + j + " : " + sum);
                if(ok)ans = min(ans, sum);
            }
        return ans;
    }
}
