import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        for(int o = 1;;o++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            if(m+n==0)break;
            int total = m*n;
            boolean[] u = new boolean[total+1];
            int[] pip = new int[n];
            for(int i = 0; i < n; i++){
                pip[i] = sc.nextInt();
                u[pip[i]] = true;
            }
            Arrays.sort(pip);
            int ans = 0;
            for(int i = n-1; i >= 0; i--){
                int b = big(pip[i], u);
                if(b > 0){
                    u[b] = true;
                }else{
                    u[small(u)] = true;
                    ans++;
                }
                for(int j = 0; j < m-2;j++)u[small(u)] = true;
            }
            System.out.printf("Case %d: %d\n", o, ans);
        }
    }

    int big(int v, boolean[] u){
        for(int i = v + 1; i < u.length; i++)
            if(!u[i])return i;
        return -1;
    }

    int small(boolean[] u){
        for(int i = 1; i < u.length; i++)
            if(!u[i])return i;
        return 0;
    }
}
