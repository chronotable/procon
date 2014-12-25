import java.util.*;
import static java.lang.Math.*;

public class WinterAndPresents{
    public long getNumber(int[] a, int[] o){
        int n = a.length;
        int x = 1<<30;
        for(int i = 0; i < n; i++)x = min(x, a[i]+o[i]);
        long ans = 0;
        for(int i = 1; i <= x; i++){
            long total = i * n;
            long apple = 0;
            long orange = 0;
            for(int j = 0; j < n; j++){
                apple += min(i, a[j]);
                orange += min(i, o[j]);
            }
            //long mnapple = total - orange;
            //ans += apple - mnapple + 1;
            long mn = min(apple, orange);
            if(mn >= total)ans += mn;
            else{long rest = apple+orange-total; ans += min(rest, mn);}
            ans++;
        }
        return ans;
    }
}