import java.util.*;
import static java.lang.Math.*;

public class ProblemSets{
    boolean ok(long e, long em, long m, long mh, long h, long lim){
        if(e + em < lim)return false;
        if(e < lim)em -= lim - e;
        if(em + m + mh < lim)return false;
        if(em + m < lim)mh -= lim - em - m;
        if(mh + h < lim)return false;
        return true;
    }
    public long maxSets(long E, long EM, long M, long MH, long H){
        long left = 0, right = 1l<<62;
        long ret = 0;
        while(left <= right){
            long m = (left + right) / 2;
            if(ok(E, EM, M, MH, H, m)){
                ret = max(ret, m);
                left = m+1;
            }else
                right = m-1;
        }
        return ret;
    }
}
