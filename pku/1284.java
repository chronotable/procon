import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] ars){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            int p = sc.nextInt();
            int ans = 0;
            /*
            loop:
            for(int i = 1; i < p;i++){
                boolean[] u = new boolean[p];
                u[0] = true;
                int n = i;
                for(int j = 0; j < p-1;j++){
                    if(u[n])continue loop;
                    u[n] = true;
                    n = (int)((1l * n * i) % p);
                }
                ans++;
            }
            */
            //System.out.println(ans);
            System.out.println(phi(p-1));
        }
    }
    static int phi(int n){
        int res = n;
        for(int i = 2; i*i <= n;i++){
            if(n%i==0){
                res -= res / i;
                while(n % i == 0){
                    n /= i;
                }
            }
        }
        if(n > 1)res -= res / n;
        return res;
    }
}
