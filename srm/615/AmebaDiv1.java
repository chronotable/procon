import java.util.*;
import static java.lang.Math.*;

public class AmebaDiv1{
    public int count(int[] X){
        HashSet<Integer> appear = new HashSet<Integer>();
        for(int x : X){
            int cur = x;
            for(int i = 0; i < X.length; i++)if(cur == X[i])cur *= 2;
            appear.add(cur);
        }
        HashSet<Integer> cand = new HashSet<Integer>();
        for(int x : X)cand.add(x);
        int ans = 0;
        for(int x : cand)if(!appear.contains(x))ans++;
        return ans;
    }
}