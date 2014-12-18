import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    static final int BASE = 100005;
    int[] c = new int[200010];
    boolean[] u = new boolean[200010];
    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Arrays.fill(c, -10000000);
        c[BASE] = 0;
        u[BASE] = true;
        int mx = BASE;
        int mn = BASE;
        for(int i = 0; i < n;i++){
            int s = sc.nextInt();
            int f = sc.nextInt();
            if(s < 0){
                for(int j = mn; j <= mx;j++){
                    if(u[j] && c[j] + f > c[j+s]){
                        c[j+s] = c[j] + f;
                        u[j+s] = true;
                    }
                }
                mn += s;
            }else{
                for(int j = mx; j >= mn;j--){
                    if(u[j] && c[j] + f > c[j+s]){
                        c[j+s] = c[j] + f;
                        u[j+s] = true;
                    }
                }
                mx += s;
            }
        }
        int ans = 0;
        for(int i = BASE; i <= mx;i++)
            if(u[i] && c[i]>0)ans = max(ans, c[i] + i - BASE);
        System.out.println(ans);
    }
}
