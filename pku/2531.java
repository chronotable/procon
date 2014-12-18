import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] ags){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] t = new int[n][n];
        for(int i = 0; i < n;i++)
            for(int j = 0; j < n; j++)
                t[i][j] = sc.nextInt();
        int lim = 1 << n;
        int ans = 0;
        for(int m = 1; m < lim; m++){
            int on = Integer.bitCount(m);
            int zn = n - on;
            int[] os = new int[on];
            int oc = 0;
            int[] zs = new int[zn];
            int zc = 0;
            for(int i = 0; i < n; i++){
                if((m & (1 << i)) != 0){
                    os[oc++] = i;
                }else{
                    zs[zc++] = i;
                }
            }
            int sum = 0;
            for(int i = 0; i < on; i++){
                for(int j = 0; j < zn; j++)
                    sum += t[os[i]][zs[j]];
            }
            ans = max(ans, sum);
        }
        System.out.println(ans);
    }
}
