import java.util.*;
import static java.lang.Math.*;

public class Procrastination{
    public long findFinalAssignee(long n){
        final long S = 200;
        TreeSet<Long> ts = new TreeSet<Long>();
        for(long i = max(2, n-S); i <= n+S; i++){
            long val = i;
            long lim = (long)sqrt(val);
            for(long j = 2; j <= lim && j <= val; j++)if(val % j == 0){
                    ts.add(j);
                    ts.add(val / j);
                }
        }
        for(long d : ts){
            if(d >= n-1)break;
            if(n % d == 0){
                n++;
            }else if((n-1) % d == 0)n--;
        }
        return n;
    }
}
