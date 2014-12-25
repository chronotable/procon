import java.util.*;
import static java.lang.Math.*;

public class WakingUp{
    boolean wake(int s, int[] period, int[] start, int[] volume, int D){
        int n = period.length;
        final int T = 100000;
        for(int i = 1; i <= T; i++){
            s += D;
            for(int j = 0; j < n; j++)if(i >= start[j] && (i-start[j]) % period[j] == 0)s -= volume[j];
            if(s <= 0)return true;
        }
        return false;
    }
    public int maxSleepiness(int[] period, int[] start, int[] volume, int D){
        int n = period.length;
        int limit = 5*7*8*9*10;
        long mn = 0;
        long cur = 0;
        for(int i = 1; i <= limit; i++){
            cur += D;
            for(int j = 0; j < n; j++)if(i >= start[j] && (i-start[j]) % period[j] == 0)cur -= volume[j];
            mn = min(cur, mn);
        }
        if(cur < 0)return -1;
        return (int)(-mn);
    }
}