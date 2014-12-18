import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int init = 0;
        int [] ms = new int[20];
        for(int i = 0; i < 20;i++){
            int v = sc.nextInt();
            init += v * (1 << i);
            ms[i] = (1<<i);
        }
        boolean[] dp = new boolean[1<<20];
        int[] q = new int[1000000];
        int[] p = new int[1000000];
        int cur = 0;
        q[cur] = init;
        p[cur++] = 0;
        dp[init] = true;
        int ans = 100;
        for(int i = 0; i < cur;i++){
            int stat = q[i];
            if(stat == 0){
                ans = p[i];
                break;
            }
            if((stat & ms[0]) > 0 || (stat & ms[1]) > 0){
                int nx = stat ^ (ms[0] + ms[1]);
                if(!dp[nx]){
                    q[cur] = nx;
                    p[cur++] = p[i] + 1;
                    dp[nx] = true;
                }
            }
            for(int j = 1; j < 19;j++){
                if((stat & (ms[j-1]+ms[j]+ms[j+1])) > 0){
                    int nx = stat ^ (ms[j-1]+ms[j]+ms[j+1]);
                    if(!dp[nx]){
                        q[cur] = nx;
                        p[cur++] = p[i] + 1;
                        dp[nx] = true;
                    }
                }
            }
            if((stat & ms[18]) > 0 || (stat & ms[19]) > 0){
                int nx = stat ^ (ms[18]+ms[19]);
                if(!dp[nx]){
                    q[cur] = nx;
                    p[cur++] = p[i] + 1;
                    dp[nx] = true;
                }
            }
        }
        System.out.println(ans);
    }

}
