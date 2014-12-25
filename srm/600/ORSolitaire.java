import java.util.*;
import static java.lang.Math.*;

public class ORSolitaire{
    public int getMinimum(int[] ns, int goal){
        int n = ns.length;
        int ans = n;
        for(int i = 0; i < 31; i++)if(((int)((goal>>i)&1)) == 1){
                int sum = 0;
                for(int j = 0; j < n; j++)if(((int)((ns[j]>>i)&1)) == 1 && (int)(goal&ns[j]) == ns[j])sum++;
                ans = min(ans, sum);
            }
        return ans;
    }
}