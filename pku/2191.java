import java.util.*;
import static java.lang.Math.*;
import java.math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        boolean[] u = new boolean[100];
        u[0] = u[1] = true;
        for(int i = 2; i < u.length; i++)
            if(!u[i])
                for(int j = i * 2; j < u.length; j += i)u[j] = true;
        int K = sc.nextInt();
        for(int i = 2; i <= K; i++){
            if(u[i])continue;
            long v = mypow(2, i) - 1;
            if(isMersennePrimeByLucalLehmer(i-1, v))continue;
            ArrayList<Long> ar = new ArrayList<Long>();
            while(v != 1){
                long p = minimalPrimeComposition(v);
                if(p == 0)p = v;
                ar.add(p);
                v /= 1l * p;
            }
            System.out.print(ar.get(0));
            for(int j = 1; j < ar.size(); j++)
                System.out.printf(" * %d", ar.get(j));
            System.out.printf(" = %d = ( 2 ^ %d ) - 1\n", mypow(2, i)-1, i);
        }
    }

    long minimalPrimeComposition(long v){
        long limit = (long)sqrt(v*1.0);
        if(v % 2 == 0)return 2;
        for(long i = 3; i <= limit; i+=2)
            if(v % i == 0)return i;
        return 0;
    }

    long mypow(long a, int b){
        if(b==0)return 1l;
        if(b % 2 == 0)return mypow(a*a, b/2);
        else return a*mypow(a*a, b/2);
    }

    boolean isMersennePrimeByLucalLehmer(int goal, long mod){
        if(goal == 1)return true;
        BigInteger[] seq = new BigInteger[100];
        BigInteger mdbi = new BigInteger(""+mod);
        BigInteger bi2 = new BigInteger("" + 2);
        seq[1] = new BigInteger("" + 4);
        for(int i = 2; i <= goal; i++){
            seq[i] = seq[i-1].multiply(seq[i-1]).subtract(bi2).mod(mdbi);
        }
        if(seq[goal].longValue() == 0)return true;
        return false;
    }
}
