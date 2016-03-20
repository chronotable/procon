import java.util.*;
import static java.lang.Math.*;

public class TreeAndPathLength3{
    private static final int MX = 500;
    public int[] construct(final int s){
        for(int z = 0; z < MX; z++){
            final int rest = s - z;
            int sq = (int)sqrt(rest);
            for(int j = 1; j <= sq; j++)if(rest % j == 0){
                    int x = j, y = rest / j;
                    int b = 2 + (z == 0 ? 0 : 1);
                    if(b + x + y + z > MX)continue;
                    System.out.println("b=" + b + " x=" + x + " y=" + y + " z=" + z);
                    if(z == 0){ // x * y == s
                        final int n = x + y + 2;
                        final int e = (n - 1) * 2;
                        int[] ret = new int[e];
                        int count = 2;
                        ret[0] = 0; ret[1] = 1;
                        for(int i = 2; i < 2 + x; i++){ret[count++] = 0; ret[count++] = i;}
                        for(int i = 2 + x; i < n; i++){ret[count++] = 1; ret[count++] = i;}
                        return ret;
                    }else{ // x * y + z == s
                        final int n = (x-1) + (y-1) + z + 4;
                        final int e = (n - 1) * 2;
                        int[] ret = new int[e];
                        int count = 0;
                        for(int i = 0; i < 3; i++){ret[count++] = i; ret[count++] = i+1;}
                        int base = 4;
                        for(int i = base; i < base + x - 1; i++){ret[count++] = 0; ret[count++] = i;}
                        base += x - 1;
                        for(int i = base; i < base + y - 1; i++){ret[count++] = 1; ret[count++] = i;}
                        base += y - 1;
                        for(int i = base; i < base + z; i++){ret[count++] = 3; ret[count++] = i;}
                        return ret;
                    }
                }
        }
        return new int[0];
    }
}
