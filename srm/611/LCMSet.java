import java.util.*;
import static java.lang.Math.*;

public class LCMSet{
    public String equal(int[] A, int[] B){
        return can(A, B) && can(B, A) ? "Equal" : "Not equal";
    }
    boolean can(int[] A, int[] B){
        for(int a : A){
            long t = 1;
            for(int b : B)if(a % b == 0)t = lcm(t, b);
            if(a != t)return false;
        }
        return true;
    }
    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
    long gcd(long a, long b) {
        if( b == 0 ) { return a; }
        return gcd(b, a % b);
    } 
}