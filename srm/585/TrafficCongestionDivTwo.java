import java.util.*;
import static java.lang.Math.*;

public class TrafficCongestionDivTwo{
    public long theMinCars(int th){
        if(th <= 2)return th<=1?1:3;
        long[] ans = new long[th+1];
        ans[1] = 1; ans[2] = 3;
        long cur = 4;
        for(int i = 3; i <= th; i++){
            ans[i] = cur + ans[i-2];
            cur <<=1;
        }
        return ans[th];
    }
}