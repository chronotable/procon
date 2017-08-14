import java.util.*;
import static java.lang.Math.*;

public class WolfDelaymaster{
    public String check(String str){
        char[] s = str.toCharArray();
        int len = s.length;
        char[] wolf = new char[]{'w', 'o', 'l', 'f'};
        int cur = 0;
        int prev = -1;
        boolean ok = true;
        for(int i = 0; i < len;){
            if(s[i] != wolf[cur]){ok = false; break;}
            int start = i;
            while(i < len && s[i] == wolf[cur])i++;
            int n = i - start;
            if(cur > 0 && n != prev){ok = false; break;}
            prev = n;
            cur = (cur+1)%4;
        }
        ok &= cur == 0;
        return ok ? "VALID" : "INVALID";
    }
}
