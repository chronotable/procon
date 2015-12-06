import java.util.*;
import static java.lang.Math.*;

public class Starport{
    long gcd(long x, long y) {
        long t;
        while (y != 0) {
            t = x % y; x = y; y = t;
        }
        return x;
    }
    public double getExpectedTime(int n, int m){
        long g = gcd(n, m);
        long lcm = 1l * n * m / g;
        long a = n / g;
        double ret = 1.0 * a * (a - 1) / 2.0 * g;
        return ret / (lcm / m);
    }
}
