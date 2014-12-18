import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            long p = sc.nextLong();
            long a = sc.nextLong();
            if(p+a==0)break;
            if(isPrime((int)p)){
                System.out.println("no");
                continue;
            }
            long ans = modpow(a,p,p) % p;
            System.out.printf("%s\n", ans==a ? "yes" : "no");
        }
    }

    static long modpow(long a, long b, long p){
        if(b==1)return a;
        if(b%2==1)return (a * modpow(a*a%p, b/2, p)) % p;
        else return modpow(a*a%p, b/2, p);
    }

    static boolean isPrime(int a){
        int sq = (int)sqrt(a*1.0);
        for(int i = 2; i<= sq; i++)
            if(a % i == 0)return false;
        return true;
    }
}
