import java.util.*;
import static java.lang.Math.*;

public class SubdividedSlimes{
    public int needCut(int S, int M){
        for(int i = 2; i <= S; i++){
            long sum = 0;
            int[] a = new int[i];
            for(int j = 0; j < i; j++)
                a[j] = S / i + (S % i > j ? 1 : 0);
            int cur = S;
            for(int j = 0; j < i; j++){
                sum += a[j] * (cur -  a[j]);
                cur -= a[j];
            }
            if(sum >= M)return i-1;
        }
        return -1;
    }
}
