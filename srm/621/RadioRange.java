import java.util.*;
import static java.lang.Math.*;

public class RadioRange{
    public double RadiusProbability(int[] x, int[] y, int[] r, int z){
        int n = x.length;
        ArrayList<Double> a = new ArrayList<Double>();
        for(int i = 0; i < n; i++){
            double d = hypot(x[i], y[i]);
            if(d - r[i] > 0)a.add(d - r[i]);
            a.add(d + r[i]);
        }
        Collections.sort(a);
        double prev = 0;
        double ans = 0;
        for(double d : a){
            if(prev > z)break;
            double m = (prev+d)/2;
            boolean contain = false;
            for(int i = 0; i < n; i++){
                double e = hypot(x[i], y[i]);
                if(e-r[i] <= m && m <= e+r[i])contain = true;
            }
            if(!contain)ans += min(d, z) - prev;
            prev = d;
        }
        ans += max(z, prev) - prev;
        return ans / z;
    }
}
