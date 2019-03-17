import java.util.*;
import static java.lang.Math.*;

public class TeamContestEasy{
    public int worstRank(int[] s){
        int n = s.length / 3;
        final int my = s[0] + s[1] + s[2] - min(s[0], min(s[1], s[2]));
        //System.out.println(my);
        int m = (n-1)*3;
        int[] t = new int[m];
        for(int i = 0; i < m; i++)t[i] = s[i+3];
        Arrays.sort(t);
        int ans = 1;
        boolean[] used = new boolean[m];
        for(int i = m-1; i >= 0; i--){
            if(used[i])continue;
            int total = t[i];
            used[i] = true;
            boolean ok = false;
            for(int j = 0; j < i; j++)if(!used[j] && total + t[j] > my){used[j] = true; ok = true; break;}
            if(!ok)break;
            for(int j = 0; j < m; j++)if(!used[j]){used[j] = true; break;}
            ans++;
        }
        return ans;
    }
}
