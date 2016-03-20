import java.util.*;
import static java.lang.Math.*;

public class WaterTank{
    boolean possible(double v, int[] t, int[] x, int C){
        final int n = t.length;
        double cur = 0;
        for(int i = 0; i < n; i++){
            double inc = x[i] - v;
            cur += inc * t[i];
            if(cur > C)return false;
            if(cur < 0)cur = 0;
        }
        return true;
    }
    public double minOutputRate(int[] t, int[] x, int C){
        double left = 0, right = 100000000;
        for(int o = 0; o < 100; o++){
            double mid = (left + right) / 2.0;
            if(possible(mid, t, x, C))right = mid;
            else left = mid;
        }
        return left;
    }
}
