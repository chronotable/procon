import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    int ans;
    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int n = sc.nextInt();
            if(n==0)break;
            n++;
            ans = 100000000;
            int[][] d = new int[n][n];
            for(int i = 0; i < n;i++)
                for(int j = 0; j < n;j++)
                    d[i][j] = sc.nextInt();
            for(int k = 0; k < n;k++)
                for(int i = 0; i < n;i++)
                    for(int j = 0; j < n;j++)
                        d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
            boolean[] v = new boolean[n];
            v[0] = true;
            tra(d, v, 0, n-1, 0);
            System.out.println(ans);
        }
    }
    void tra(int[][] d, boolean[] v, int cur, int rest, int total){
        if(rest == 0){
            total += d[cur][0];
            ans = min(ans, total);
            return;
        }
        for(int i = 1; i < v.length;i++){
            if(v[i])continue;
            v[i] = true;
            tra(d, v, i, rest-1, total + d[cur][i]);
            v[i] = false;
        }
    }
}
