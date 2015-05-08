import java.util.*;
import static java.lang.Math.*;

public class BuildingTowersEasy{
    int[] getMx(int N, int[] x, int[] t){
        int a = x.length;
        int[] mx = new int[a];
        mx[0] = min(x[0]-1, t[0]);
        for(int i = 1; i < a; i++){
            mx[i] = min(mx[i-1] + x[i] - x[i-1], t[i]);
        }
        return mx;
    }
    public int maxHeight(int N, int[] x, int[] t){
        int a = x.length;
        if(a == 0)return N-1;
        int[] mx = getMx(N, x, t);
        for(int i = 0; i < a; i++){
            for(int j = 0; j < a; j++)if(i != j)mx[j] = min(mx[j], t[i] + abs(x[i] - x[j]));
        }
    
        int ans = 0;
        for(int m : mx)ans = max(ans, m);
        ans = max(ans, mx[a-1] + N - x[a-1]);
        ans = max(ans, mx[0] + (x[0] - mx[0]) / 2);
        for(int i = 1; i < a; i++)
            ans = max(ans, max(mx[i], mx[i-1]) + (x[i] - x[i-1] - abs(mx[i-1] - mx[i])) / 2);
        return ans;
    }
}
