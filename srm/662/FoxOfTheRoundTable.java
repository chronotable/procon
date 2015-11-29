import java.util.*;
import static java.lang.Math.*;

public class FoxesOfTheRoundTable{
    int n;
    int[] a;
    boolean possible(int[] hi, int lim){
        int[] r = new int[n];
        r[0] = hi[0] / n; a[0] = hi[0] % n;
        r[1] = hi[1] / n; a[1] = hi[1] % n;
        r[n-1] = hi[2] / n; a[n-1] = hi[2] % n;
        int left = n-2, right = 2;
        for(int i = 3; i < n; i++){
            int h = hi[i] / n;
            int index = hi[i] % n;
            int ldif = abs(h - r[left+1]);
            int rdif = abs(h - r[right-1]);
            if(ldif > rdif){
                if(ldif > lim)return false;
                r[left] = h;
                a[left] = index;
                left--;
            }else{
                if(rdif > lim)return false;
                r[right] = h;
                a[right] = index;
                right++;
            }
        }
        for(int i = 0; i < n; i++)if(abs(r[i] - r[(i+1)%n]) > lim)return false;
        return true;
    }
    public int[] minimalDifference(int[] h){
        n = h.length;
        a = new int[n];
        int[] hi = new int[n];
        for(int i = 0; i < n; i++)hi[i] = h[i] * n + i;
        Arrays.sort(hi);
        int left = 0, right = 1000;
        while(left <= right){
            int m = (left+right)/2;
            if(possible(hi, m))right = m-1;
            else left = m+1;
        }
        possible(hi, left);
        return a;
    }
}
