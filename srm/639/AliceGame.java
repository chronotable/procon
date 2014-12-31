import java.util.*;
import static java.lang.Math.*;

public class AliceGame{
    public long findMinimumValue(long x, long y){
        long t = x + y;
        long s = (long)sqrt(t);
        if(s*s != t)return -1;
        long ans = 0;
        for(;s > 0; s--){
            if(x >= s*2-1 && x != s*2+1){x -= s*2-1; ans++;}
            else y -= s*2-1;
        }
        if(x==0 && y==0)return ans;
        return -1;
    }
}
