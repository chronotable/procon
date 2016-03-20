import java.util.*;
import static java.lang.Math.*;

public class ANewHope{
    public int count(int[] fw, int[] lw, int D){
        final int n = fw.length;
        int mx = 0;
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)if(fw[i] == lw[j])mx = max(mx, i - j);
        if(mx == 0)return 1;
        return (mx-1) / (n-D) + 2;
    }
}
