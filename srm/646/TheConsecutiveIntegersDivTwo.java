import java.util.*;
import static java.lang.Math.*;

public class TheConsecutiveIntegersDivTwo{
    public int find(int[] n, int k){
        int m = n.length;
        Arrays.sort(n);
        if(k == 1)return 0;
        int ret = 1<<30;
        for(int i = 1; i < m; i++)ret = min(ret, n[i]-n[i-1]-1);
        return ret;
    }
}
