import java.util.*;
import static java.lang.Math.*;

public class TheNumberGameDiv2{
    private int reverse(int a){
        int ret = 0;
        while(a > 0){
            ret = ret * 10 + a % 10;
            a /= 10;
        }
        return ret;
    }
    public int minimumMoves(int A, int B){
        HashSet<Integer> used = new HashSet<Integer>();
        HashSet<Integer> cur = new HashSet<Integer>();
        cur.add(A);
        for(int ans = 0; ; ans++){
            if(cur.size() == 0)break;
            HashSet<Integer> next = new HashSet<Integer>();
            for(Integer v : cur){
                if(v == B)return ans;
                if(v < 10)continue;
                int r = reverse(v);
                if(!used.contains(r)){
                    next.add(r);
                    used.add(r);
                }
                int w = v / 10;
                if(!used.contains(w)){
                    next.add(w);
                    used.add(w);
                }
            }
            cur = next;
        }
        return -1;
    }
}
