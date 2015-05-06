import java.util.*;
import static java.lang.Math.*;

public class TheConsecutiveIntegersDivOne{
    int n;
    int calc(int[] num, int k, int start, int val){
        int ret = 0;
        for(int i = start; i < start+k; i++)ret += abs(num[i] - val++);
        return ret;
    }
    int trisearch(int[] num, int k, int start){
        int left = num[start]-k;
        int right = num[start+k-1]+k;
        int ret = 1<<30;
        for(int i = 0; i < 200; i++){
            int ml = (left+left+right)/3;
            int mr = (left+right+right)/3;
            int mlv = calc(num, k, start, ml);
            int mrv = calc(num, k, start, mr);
            ret = min(ret, min(mlv, mrv));
            if(mlv > mrv){
                left = ml;
            }else{
                right = mr;
            }
        }
        return ret;
    }
    public int find(int[] num, int k){
        if(k == 1)return 0;
        n = num.length;
        Arrays.sort(num);
        int ans = 1<<30;
        for(int i = 0; i <= n-k; i++)
            ans = min(ans, trisearch(num, k, i));
        return ans;
    }
}

