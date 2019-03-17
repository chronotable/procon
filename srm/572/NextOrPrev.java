import java.util.*;
import static java.lang.Math.*;

public class NextOrPrev{
    public int getMinimum(int nc, int pc, String start, String goal){
        char[] s = start.toCharArray();
        char[] g = goal.toCharArray();
        int n = s.length;
        int[] to = new int[26];
        Arrays.fill(to, -1);
        for(int i = 0; i < n; i++)to[s[i] - 'a'] = g[i] - 'a';
        for(int i = 0; i < to.length; i++)for(int j = i+1; j < to.length; j++)if(to[i] != -1 && to[j] != -1 && to[i] > to[j])return -1;
        int ans = 0;
        for(int i = 0; i < to.length; i++)if(to[i] != -1){
                if(i < to[i])ans += nc * (to[i] - i);
                if(i > to[i])ans += pc * (i - to[i]);
            }
        return ans;
    }
}
