import java.util.*;
import static java.lang.Math.*;

public class Bracket107{
    int n;
    char[] S;
    public int yetanother(String s){
        S = s.toCharArray();
        n = S.length;
        HashSet<String> h = new HashSet<String>();
        for(int i = 0; i < n; i++){
            String t = s.substring(0, i) + s.substring(i+1);
            for(int j = 0; j < n; j++)h.add(t.substring(0, j) + S[i] + t.substring(j));
        }
        int ans = 0;
        for(String t : h)if(!s.equals(t)){
                boolean ok = true;
                int cur = 0;
                for(int i = 0; i < n; i++){
                    if(t.charAt(i) == '(')cur++;
                    else cur--;
                    if(cur < 0){
                        ok = false;
                        break;
                    }
                }
                if(ok)ans++;
            }
        return ans;
    }
}