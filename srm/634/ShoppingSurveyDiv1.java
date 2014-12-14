import java.util.*;
import static java.lang.Math.*;

public class ShoppingSurveyDiv1{
    boolean possible(int rest, int K, int[] t){
        while(rest-- > 0){
            Arrays.sort(t);
            for(int i = 0; i < K-1; i++)t[t.length-1-i]--;
        }
        Arrays.sort(t);
        return t[t.length-1] <= 0;
    }
    public int minValue(int N, int K, int[] s){
        int M = s.length;
        for(int r = 0; r <= N; r++){
            int[] t = new int[M];
            for(int i = 0; i < M; i++)t[i] = s[i];
            for(int i = 0; i < r; i++)for(int j = 0; j < M; j++)if(t[j]>0)t[j]--;
            if(possible(N-r, K, t))return r;
        }
        return N;
    }
}
