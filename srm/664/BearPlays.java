import java.util.*;
import static java.lang.Math.*;

public class BearPlays{
    public static long modpow(long a, long n, long mod){
        long ret = 1;
        long mul = a;
        for(;n > 0;n >>>= 1){
            if((n&1)==1){
                ret = (ret * mul) % mod;
            }
            mul = (mul * mul) % mod;
        }
        return ret;
    }
    public int pileSize(int A, int B, int K){
        long C = A + B;
        long a = 1l * A * modpow(2, K, C);
        a %= C;
        long b = C - a;
        return (int)min(a, b);
    }
    /*
  // try to find the cycle, but TLE
  public int pileSize(int A, int B, int K){
    HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    //final long BASE = 1000000007;
    final int sum = A + B;
    final int half = sum / 2;
    int i = 0;
    for(; i < K;){
      if(A > B){int t = A; A = B; B = t;}
      if(A == 0)return 0;
      if(memo.containsKey(A)){
        int prev = memo.get(A);
        int dif = i - prev;
        int rest = K - i;
        i += rest / dif * dif;
        break;
      }
      memo.put(A, i);
      while(i < K && A <= half){A <<= 1; i++;}
      B = A;
      A = sum - B;
      if(i == K)break;
    }
    System.out.println("rest=" + (K - i));
    for(; i < K; i++){
      if(A > B){int t = A; A = B; B = t;}
      if(A == 0)return 0;
      B -= A;
      A += A;
    }
    return A < B ? A : B;
  }
    */
}
