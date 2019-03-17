import java.util.*;
import static java.lang.Math.*;

public class UndoHistory{
    int prefixLen(String a, String b){
        int mn = min(a.length(), b.length());
        int i = 0;
        for(; i < mn; i++)if(a.charAt(i) != b.charAt(i))break;
        return i;
    }
    public int minPresses(String[] lines){
        int n = lines.length;
        int ans = lines[0].length() + 1;
        for(int o = 1; o < n; o++){
            int mx = 0;
            for(int i = 0; i < o; i++)mx = max(mx, prefixLen(lines[o], lines[i]));
            int prev = prefixLen(lines[o], lines[o-1]);
            int cost = 2 + lines[o].length() - mx;
            if(prev == lines[o-1].length()){
                cost = min(cost, lines[o].length() - prev);
            }
            ans += cost + 1;
        }
        return ans;
    }
}
