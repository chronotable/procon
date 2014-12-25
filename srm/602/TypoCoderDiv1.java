import java.util.*;
import static java.lang.Math.*;

public class TypoCoderDiv1{
    private void renew(Hashtable<Long, Integer> next, long key, int val){
        if(next.containsKey(key)){
            next.put(key, max(val, next.get(key)));
        }else{
            next.put(key, val);
        }
    }
    public int getmax(int[] D, int X){
        int n = D.length;
        final long BASE = 100;
        Hashtable<Long, Integer> cur = new Hashtable<Long, Integer>();
        cur.put(X*1l, 0);
        for(int i = 0; i < n; i++){
            int d = D[i];
            Hashtable<Long, Integer> next = new Hashtable<Long, Integer>();
            //System.out.print("keys" + i + ":");
            for(Long k : cur.keySet()){
                int val = cur.get(k);
                //System.out.print(k + "(" + val + ") ");
                if(k >= 2200){
                    long nk = k - d;
                    if(nk < 0)nk = 0;
                    if(nk >= 2200)continue;
                    renew(next, nk, val+1);
                }else{
                    long nk = k - d;
                    if(nk < 0)nk = 0;
                    renew(next, nk, val);
                    nk = k + d;
                    if(nk >= 2200){
                        renew(next, nk, val+1);
                    }else{
                        renew(next, nk, val);
                    }
                }
            }
            //System.out.println();
            cur = next;
        }
        int ans = 0;
        for(Long key : cur.keySet())ans = max(ans, cur.get(key));
        return ans;
    }
}