import java.util.*;
import static java.lang.Math.*;

public class AlienAndHamburgers{
    public int getNumber(int[] type, int[] taste){
        int n = type.length;
        HashSet<Integer> ts = new HashSet<Integer>();
        for(int t : type)ts.add(t);
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int t : ts){
            int sum = 0;
            int mx = -(1<<20);
            for(int i = 0; i < n; i++)if(type[i] == t){
                    if(taste[i] > 0)sum += taste[i];
                    else if(mx < taste[i])mx = taste[i];
                }
            if(sum > 0)a.add(sum);
            else a.add(mx);
        }
        int ans = 0;
        Collections.sort(a);
        int m = a.size();
        int sum = 0;
        for(int i = m-1; i >= 0; i--){
            sum += a.get(i);
            ans = max(ans, sum * (m-i));
        }
        return ans;
    }
}