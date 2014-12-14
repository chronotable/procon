import java.util.*;
import java.lang.Math.*;

public class FixedDiceGameDiv1{
    double[] calc(int a, int b){
        int t = a * b;
        double[] ret = new double[t+1];
        ret[0] = 1.0;
        for(int i = 0; i < a; i++){
            double[] next = new double[t+1];
            for(int j = 0; j < ret.length; j++)for(int k = 1; k <= b; k++)if(j+k < ret.length)
                                                                              next[j+k] += ret[j] / b;
            ret = next;
        }
        return ret;
    }
    public double getExpectation(int a, int b, int c, int d){
        double[] alice = calc(a, b);
        double[] bob = calc(c, d);
        double win = 0;
        double sum = 0;
        for(int i = 0; i < alice.length; i++)
            for(int j = 0; j < i && j < bob.length; j++){
                double p = alice[i] * bob[j];
                win += p;
                sum += i * p;
            }
        if(win < 1e-300)return -1;
        return sum / win;
    }
}
