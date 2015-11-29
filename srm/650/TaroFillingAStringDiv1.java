import java.util.*;
import static java.lang.Math.*;

public class TaroFillingAStringDiv1{
    final int MOD = 1000000007;
    public int getNumber(int N, int[] pos, String value){
        int n = pos.length;
        E[] tbl = new E[n];
        for(int i = 0; i < n; i++)tbl[i] = new E(pos[i], i);
        Arrays.sort(tbl);
        char[] v = value.toCharArray();
        long ans = 1;
        for(int i = 1; i < n; i++){
            int d = tbl[i].p - tbl[i-1].p - 1;
            boolean same = v[tbl[i].i] == v[tbl[i-1].i];
            if(d == 0)continue;
            if(d % 2 == 0 && same || (d % 2 == 1 && !same)){
                ans = (ans * (d + 1)) % MOD;
            }
        }
        return (int)ans;
    }
}

class E implements Comparable<E>{
    int p, i;
    E(int pos, int ind){
        p = pos;
        i = ind;
    }
    public int compareTo(E e){
        return this.p - e.p;
    }
}
