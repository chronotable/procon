import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] u = new boolean[100000];
        ArrayList<Long> pr = new ArrayList<Long>();
        for(int i = 2; i < u.length;i++){
            if(!u[i]){
                pr.add(i * 1l);
                for(int j = i * 2;j < u.length;j += i)u[j] = true;
            }
        }
        Hashtable<Long, Integer> ht = new Hashtable<Long, Integer>();
        for(;;){
            long o = sc.nextLong();
            long n = abs(o);
            if(n==0)break;
            ht.clear();
            int sn = (int)sqrt(n) + 1;
            for(int i = 0; i < pr.size();i++){
                long a = pr.get(i);
                if(a>sn || a > n)break;
                while(n%a==0){
                    if(!ht.containsKey(a))ht.put(a,1);
                    else ht.put(a, ht.get(a) + 1);
                    n /= a;
                }
            }
            if(n!=1){System.out.println("1");continue;}
            int ans = 1;
            for(int i = 2; i < 32; i++){
                if(o<0 && i % 2 == 0)continue;
                Enumeration<Long> enm = ht.keys();
                boolean f = true;
                for(;enm.hasMoreElements();){
                    long k = enm.nextElement();
                    int b = ht.get(k);
                    if(b % i != 0){f = false;break;}
                }
                if(f) ans = i;
            }
            System.out.println(ans);
        }
    }
}
