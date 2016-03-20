import java.util.*;
import static java.lang.Math.*;

public class CrouchingAmoebas{
    public int count(int[] x, int[] y, int A, int T){
        int n = x.length;
        int ans = 1;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int[] mn_mx_x = new int[2];
                int[] mn_mx_y = new int[2];
                mn_mx_x[0] = min(x[i], x[j]);
                mn_mx_x[1] = max(x[i], x[j]);
                mn_mx_y[0] = min(y[i], y[j]);
                mn_mx_y[1] = max(y[i], y[j]);
                for(int a = 0; a < mn_mx_x.length; a++)for(int b = 0; b < mn_mx_y.length; b++){
                        ans = max(ans, calc(x, y, A, T, mn_mx_x[a]-A, mn_mx_y[b]-A));
                        ans = max(ans, calc(x, y, A, T, mn_mx_x[a]-A, mn_mx_y[b]));
                        ans = max(ans, calc(x, y, A, T, mn_mx_x[a], mn_mx_y[b]-A));
                        ans = max(ans, calc(x, y, A, T, mn_mx_x[a], mn_mx_y[b]));
                    }
            }
        }
        return ans;
    }
    int calc(int[] x, int[] y, int A, long T, long sx, long sy){
        int n = x.length;
        ArrayList<Long> dis = new ArrayList<Long>();
        for(int i = 0; i < n; i++){
            dis.add(len(sx, sy, A, x[i], y[i]));
        }
        Collections.sort(dis);
        int ret = 0;
        for(int i = 0; i < n; i++){
            if(dis.get(i) > T)break;
            T -= dis.get(i);
            ret++;
        }
        return ret;
    }
    long len(long sx, long sy, long A, long x, long y){
        if(sx <= x && x <= sx + A){
            if(sy <= y && y <= sy + A)return 0; //inside
            return min(abs(sy - y), abs(sy+A-y));
        }else{
            if(sy <= y && y <= sy + A){
                return min(abs(sx - x), abs(sx+A-x));
            }else{
                long ret = Long.MAX_VALUE;
                ret = min(ret, (long)abs(sx - x) + abs(sy - y));
                ret = min(ret, (long)abs(sx + A - x) + abs(sy - y));
                ret = min(ret, (long)abs(sx - x) + abs(sy + A - y));
                ret = min(ret, (long)abs(sx + A - x) + abs(sy + A - y));
                //System.out.println(ret);
                return ret;
            }
        }
    }
}