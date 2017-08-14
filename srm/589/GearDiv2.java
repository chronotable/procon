import java.util.*;
import static java.lang.Math.*;

public class GearsDiv2{
    public int getmin(String dir){
        char[] d = dir.toCharArray();
        final int n = d.length;
        int ans = n;
        for(int i = 0; i < n; i++){
            char cur = d[i];
            int sum = 0;
            for(int j = 1; j < n; j++){
                int k = (i + j) % n;
                if(cur == d[k]){
                    sum++;
                    cur = 0;
                }else{
                    cur = d[k];
                }
            }
            if(cur == d[i])sum++;
            ans = min(ans, sum);
        }
        return ans;
    }
}
