import java.util.*;
import static java.lang.Math.*;

public class JanuszTheBusinessman{
    public int makeGuestsReturn(int[] A, int[] D){
        int n = A.length;
        final int B = 1000;
        int[] b = new int[n];
        for(int i = 0; i < n; i++)b[i] = D[i] * B + A[i];
        Arrays.sort(b);
        int ret = 0;
        boolean[] used = new boolean[n];
        for(int i = 0; i < n; i++)if(!used[i]){
                int cd = b[i] / B;
                int index = -1;
                ret++;
                for(int j = 0; j < n; j++){
                    int a = b[j] % B;
                    int d = b[j] / B;
                    if(a <= cd && cd <= d){
                        if(index < 0 || b[index] / B < d)index = j;
                    }
                }
                cd = b[index] / B;
                int ca = b[index] % B;
                for(int j = 0; j < n; j++){
                    int a = b[j] % B;
                    int d = b[j] / B;
                    if((ca <= a && a <= cd) || (ca <= d && d <= cd))used[j] = true;
                }
            }
        return ret;
    }
}
