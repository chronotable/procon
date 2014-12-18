import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int lim = 1<<20;
        long[] tb = new long[20];
        tb[0] = 1l;
        for(int i = 1; i < 20;i++)tb[i] = 3l * tb[i-1];

        outer:
        for(int o = sc.nextInt();o > 0;o--){
            int w = sc.nextInt();
            loop:
            for(int i = 0; i < lim;i++){
                long t = w;
                for(int j = 0; j < 20;j++){
                    if((i & (1<<j)) != 0)t += tb[j];
                }
                int v = 0;
                int n = 1;
                for(;t>0;){
                    int mod = (int)(t % 3);
                    if(mod == 2)continue loop;
                    v += mod * n;
                    t /= 3l;
                    n *= 2;
                }
                if((i & v) == 0){
                    //System.out.println(i + " " + v);
                    System.out.println(tos(i,tb) + " " + tos(v,tb));
                    continue outer;
                }
            }
        }
    }
    static String tos(int n, long[] tb){
        if(n==0)return "empty";
        boolean[] u = new boolean[20];
        int endind = -1;
        for(int i = 0; i < 20;i++){
            if((n & (1<<i)) != 0){
                u[i] = true;
                endind = i;
            }
        }
        String res = "";
        for(int i = 0; i < 20;i++){
            if(u[i]){
                res = res + tb[i];
                if(i!=endind)res = res + ",";
            }
        }
        return res;
    }
}
