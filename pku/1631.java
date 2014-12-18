import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(int o = sc.nextInt(); o > 0; o--){
            int t = sc.nextInt();
            int[] s = new int[t];
            for(int i = 0; i < t; i++)
                s[i] = sc.nextInt();
            System.out.println(LIS.lisFast(s).length);
        }
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
            id[i] = Arrays.binarySearch(A, a[i]);
            if(id[i] < 0) id[i] = -(id[i]+1);
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

    static int[] lisFastAllowDuplicate(int[] a){
        int n = a.length;
        int[] A = new int[n];
        Arrays.fill(A, INF);
        int[] id = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = Arrays.binarySearch(A, a[i]);
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

    /* test run */
    public static void main(String[] args){
        //int[] a = new int[]{-23,4,9,9,-22,34,2345,3456,-9,0,1,-3,7000,7000};
        //int[] a = new int[]{1,1,1,1,1,1,1,1,1,1};
        int[] a = new int[]{1,1,1,1,2,2,2,2,1,1,1,1,1,2,2,2,2,2};
        int[] b = lisFast(a);
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");
        System.out.println();
    }

}
