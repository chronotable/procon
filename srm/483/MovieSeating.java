import java.util.*;
import static java.lang.Math.*;

public class MovieSeating{
    long calc(int n, char[] a){
        int m = 0;
        for(int i = 0; i < a.length; i++)if(a[i] == '.')m++;
        if(n > m)return 0;
        long ans = 1;
        for(int i = 0; i < n; i++)ans *= m - i;
        return ans;
    }
    public long getSeatings(int nf, String[] hall){
        int h = hall.length;
        int w = hall[0].length();
        char[][] f = new char[h][];
        for(int i = 0; i < h; i++)f[i] = hall[i].toCharArray();
        char[][] g = new char[w][h];
        for(int i = 0; i < w; i++)for(int j = 0; j < h; j++)g[i][j] = f[j][i];
        long ans = 0;
        for(int i = 0; i < h; i++)ans += calc(nf, f[i]);
        if(nf > 1)for(int i = 0; i < w; i++)ans += calc(nf, g[i]);
        return ans;
    }
}
