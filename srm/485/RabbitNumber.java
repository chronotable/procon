import java.util.*;
import static java.lang.Math.*;

public class RabbitNumber{
    long ds(long v){
        long ret = 0;
        while(v > 0){
            ret += v % 10;
            v /= 10;
        }
        return ret;
    }
    int calc(int upper, ArrayList<Integer> a){
        int ind = Collections.binarySearch(a, upper);
        if(ind < 0)ind = -ind - 2;
        return ind;
    }
    public int theCount(int low, int high){
        ArrayList<Integer> rn = new ArrayList<Integer>();
        int lim = 1<<18;
        for(int i = 1; i < lim; i++){
            long val = 0;
            for(int j = 0; j < 9; j++){
                int d = (int)((i >> (j<<1)) & 3);
                val = val * 10 + d;
            }
            long a = ds(val);
            long b = ds(val*val);
            if(a * a == b){
                rn.add((int)val);
            }
        }
        rn.add(1000000000);
        Collections.sort(rn);
        return calc(high, rn) - calc(low-1, rn);
    }
}
