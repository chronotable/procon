import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
        for(;z>0;z--){
            long m = sc.nextInt() * 1l;
            int h = sc.nextInt();
            long ans = 0;
            for(int i = 0; i < h; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                ans += mypow(a, b, m);
                ans %= m;
            }
            System.out.println(ans);
        }
    }

    long mypow(long a, long b, long m){
        if(b == 0)return 1l;
        if(b % 2 == 1)return a * mypow(a*a % m, b / 2, m) % m;
        else return mypow(a*a%m, b / 2, m) % m;
    }
}