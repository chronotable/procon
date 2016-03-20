import java.util.*;
import static java.lang.Math.*;

public class FiringEmployees{
    public int fire(int[] m, int[] s, int[] p){
        final int n = m.length;
        int[] v = new int[n+1];
        for(int i = n; i > 0; i--)
            v[m[i-1]] += max(0, v[i] + p[i-1] - s[i-1]);
        return v[0];
    }
}
