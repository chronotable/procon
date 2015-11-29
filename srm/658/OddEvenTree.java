import java.util.*;
import static java.lang.Math.*;

public class OddEvenTree{
    public int[] getTree(String[] X){
        int n = X.length;
        char[][] x = new char[n][];
        for(int i = 0; i < n; i++)x[i] = X[i].toCharArray();
        // self loop
        for(int i = 0; i < n; i++)if(x[i][i] != 'E')return new int[]{-1};
        // symmetry
        for(int i = 0; i < n; i++)for(int j = i+1; j < n; j++)if(x[i][j] != x[j][i])return new int[]{-1};

        long mask = 0;
        for(int i = 0; i < n; i++)if(x[0][i] == 'O')mask |= 1l << i;
        for(int i = 1; i < n; i++){
            long m = 0;
            for(int j = 0; j < n; j++)if(x[i][j] == 'O')m |= 1l << j;
            long res = mask ^ m;
            if(res != 0 && res != (1l<<n)-1)return new int[]{-1};
        }
        int m = 2*n - 2;
        int[] ret = new int[m];
        int count = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(x[0][i] == 'E')a.add(i);
            else b.add(i);
        }
        if(a.size() == 0 || b.size() == 0)return new int[]{-1};
        for(int i = 0; i < b.size(); i++){ret[count++] = a.get(0); ret[count++] = b.get(i);}
        for(int i = 1; i < a.size(); i++){ret[count++] = a.get(i); ret[count++] = b.get(0);}
        return ret;
    }
}
