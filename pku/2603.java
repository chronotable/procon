import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ps = new ArrayList<Integer>();
        boolean[] u = new boolean[10001];
        for(int i = 2; i < u.length; i++){
            if(!u[i]){
                ps.add(i);
                for(int j = i * 2; j < u.length; j += i)
                    u[j] = true;
            }
        }
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        long cur = 1l * sc.nextInt();
        for(;sc.hasNext();){
            int v = sc.nextInt();
            cur *= v;
            for(int i = 0; i < ps.size(); i++){
                int p = ps.get(i);
                while(cur % p == 0){
                    if(!ht.containsKey(p))ht.put(p, 1);
                    else ht.put(p, ht.get(p) + 1);
                    cur /= p;
                }
            }
        }
        if(cur > 1l){
            if(!ht.containsKey((int)cur))ht.put((int)cur, 1);
            else ht.put((int)cur, ht.get((int)cur) + 1);
        }
        Enumeration<Integer> it = ht.keys();
        long ans = 1;
        for(;it.hasMoreElements();)ans *= ht.get(it.nextElement()) + 1;
        System.out.println(ans % 10);
    }
}
