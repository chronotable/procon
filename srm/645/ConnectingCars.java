import java.util.*;
import static java.lang.Math.*;

public class ConnectingCars{
    public long minimizeCost(int[] p, int[] len){
        int n = p.length;
        C[] cs = new C[n];
        for(int i = 0; i < n; i++)cs[i] = new C(p[i], len[i]);
        Arrays.sort(cs);
        long ret = 1l<<60;
        for(int i = 0; i < n; i++){
            long sum = 0;
            int cur = cs[i].p;
            for(int j = i-1; j >= 0; j--){
                sum += cur - (cs[j].p + cs[j].len);
                cur -= cs[j].len;
            }
            cur = cs[i].p + cs[i].len;
            for(int j = i+1; j < n; j++){
                sum += cs[j].p - cur;
                cur += cs[j].len;
            }
            ret = min(ret, sum);
        }
        return ret;
    }
}

class C implements Comparable<C>{
    public int p, len;
    C(int _p, int _l){
        p = _p;
        len = _l;
    }
    public int compareTo(C c){
        return p - c.p;
    }
}
