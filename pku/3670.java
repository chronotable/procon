import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for(int i = 0; i < n; i++)d[i] = sc.nextInt();
        int[] s = LIS.lisFast(d);
        int[] nd = new int[n];
        for(int i = 0; i < n; i++)
            nd[i] = d[n-i-1];
        int[] t = LIS.lisFast(nd);
        int ans = min(n-s.length, n-t.length);
        System.out.println(ans);
    }
}


class LIS{
    private static final int INF = 1<<30;

    static int[] lisFast(int[] a){
        int n = a.length;
        int[] A = new int[n];
        Arrays.fill(A, INF);
        int[] id = new int[n];
        for(int i = 0; i < n; i++){
            //id[i] = Arrays.binarySearch(A, a[i]);
            id[i] = Arrays.binarySearch(A, a[i]); //if allow duplicate
            if(id[i] < 0) id[i] = -(id[i]+1);
            while(id[i] < n && A[id[i]] <= a[i])id[i]++;
            if(id[i] == n)id[i]--;
            A[id[i]] = a[i];
        }
        int m = 0;
        for(int i = 0; i < n; i++)
            m = max(m, id[i]);
        int[] ret = new int[m+1];
        for(int i = n-1; i >= 0; i--)
            if(id[i] == m) ret[m--] = a[i];
        return ret;
    }


}
