import java.util.*;
import static java.lang.Math.*;

public class WaitingForBus{
    public double whenWillBusArrive(int[] time, int[] prob, int s){
        final int L = 300000;
        double[] p = new double[L];
        p[0] = 1.0;
        int n = time.length;
        for(int i = 0; i < s; i++){
            if(p[i] == 0)continue;
            for(int j = 0; j < n; j++){
                if(i + time[j] >= L)continue;
                p[i+time[j]] += p[i] * prob[j] / 100;
            }
        }
        double ans = 0;
        for(int i = s+1; i < L; i++){
            ans += (i-s) * p[i];
            //if(p[i]>0)System.out.println(i + " " + p[i]);
        }
        return ans;
    }
}
