import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    static final int INF = 1<<20;
    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int et = sc.nextInt();
        int[][] con = new int[n][n];
        for(int i = 0; i < n;i++)Arrays.fill(con[i], INF);
        for(;sc.hasNext();)con[sc.nextInt()][sc.nextInt()] = 1;
        int[][] g = new int[n][n];
        for(int i = 0; i < n;i++)
            for(int j = 0; j < n;j++)g[i][j] = con[i][j];
        for(int k = 0;k < n;k++)
            for(int i = 0; i < n;i++)
                for(int j = 0; j < n;j++)
                    g[i][j] = min(g[i][j],g[i][k]+g[k][j]);
        int ans = 0;
        int mn = INF;
        for(int p = 0; p < n;p++){
            if(p!=et && g[p][et] < mn){
                int[][] h = new int[n][n];
                for(int i = 0; i < n;i++)
                    for(int j = 0; j < n;j++)
                        h[i][j] = con[i][j];
                for(int i = 0; i < n; i++)h[i][p]=INF;
                for(int k = 0; k < n;k++)
                    for(int i = 0; i < n;i++)
                        for(int j = 0; j < n;j++)
                            h[i][j]=min(h[i][j],h[i][k]+h[k][j]);
                if(h[0][et] >= INF){
                    mn = g[p][et];
                    ans = p;
                }
            }
        }
        System.out.printf("Put guards in room %d.\n", ans);
    }
}