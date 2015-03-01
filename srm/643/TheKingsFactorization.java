import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TheKingsFactorization{
    public static long modpow(long a, long n, long mod){
        BigInteger ret = new BigInteger(1 + "");
        BigInteger mul = new BigInteger(a + "");
        BigInteger MOD = new BigInteger(mod + "");
        for(;n > 0;n >>>= 1){
            if((n&1)==1){
                ret = (ret.multiply(mul)).mod(MOD);
            }
            mul = (mul.multiply(mul)).mod(MOD);
        }
        return ret.longValue();
    }
    boolean isPrime(long v){
        if(v == 2)return true;
        if(v < 2 || v % 2 == 0)return false;
        return modpow(2, v-1, v) == 1;
    }

    public long[] getVector(long N, long[] primes){
        long t = N;
        ArrayList<Long> a = new ArrayList<Long>();
        for(long p : primes){t /= p; a.add(p);}
        if(t > 100000000 && isPrime(t)){
            a.add(t);
            t = 1;
        }
        for(long i = 2; i * i <= t; i++)if(t%i == 0){
                while(t % i == 0){
                    a.add(i); t /= i;
                }
                if(t > 100000000 && isPrime(t)){
                    a.add(t);
                    t = 1;
                }
            }
        //if(!isPrime(t))System.out.println(t + " is not prime");
        //System.out.println(t);
        if(t > 1)a.add(t);
        Collections.sort(a);
        int m = a.size();
        long[] ans = new long[m];
        for(int i = 0; i < m; i++)ans[i] = a.get(i);
        return ans;
    }
}
