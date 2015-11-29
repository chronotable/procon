import java.util.*;
import static java.lang.Math.*;

public class ApplesAndOrangesEasy{
    public int maximumApples(int N, int K, int[] info){
        int h = K / 2;
        int[] b = new int[N];
        for(int i : info)b[i-1] = 1;
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = 1;
            int sum = 0;
            for(int j = max(i-K+1, 0); j <= i; j++)sum += a[j];
            if(sum > h){
                int low = max(i-K+1, 0);
                for(int j = i; j >= low; j--)if(a[j] == 1 && b[j] == 0){
                        a[j] = 0;
                        break;
                    }
            }
        }
        int ret = 0;
        for(int v : a)ret += v;
        return ret;
    }
}
