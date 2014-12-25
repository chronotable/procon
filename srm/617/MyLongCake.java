import java.util.*;
import static java.lang.Math.*;

public class MyLongCake{
    public int cut(int n){
        boolean[] line = new boolean[n];
        for(int i = 1; i < n; i++)if(n % i == 0){
                int m = n / i;
                for(int j = m; j < n; j += m)line[j] = true;
            }
        int ans = 1;
        for(int i = 0; i < n; i++)if(line[i])ans++;
        return ans;
    }
}