import java.util.*;
import static java.lang.Math.*;

public class TimeTravellingSalesman{
    public long determineCost(int n, String[] roads){
        int INF = 1<<30;
        String all = "";
        for(String s : roads)all += s;
        String[] r = all.split(" ");
        int[][] dis = new int[n][n];
        for(int i = 0; i < n; i++){Arrays.fill(dis[i], INF); dis[i][i] = 0;}
        for(String s : r){
            String[] t = s.split(",");
            int a = Integer.parseInt(t[0]);
            int b = Integer.parseInt(t[1]);
            int d = Integer.parseInt(t[2]);
            dis[a][b] = dis[b][a] = min(dis[a][b], d);
        }
        int rest = n-1;
        long sum = 0;
        for(int i = 1; i < n; i++){
            int ind = -1;
            int mn = INF;
            for(int j = 1; j < n; j++){
                if(dis[0][j] < 0 || dis[0][j] == INF)continue;
                if(dis[0][j] < mn){
                    mn = dis[0][j];
                    ind = j;
                }
            }
            if(ind < 0)break;
            rest--;
            sum += mn;
            for(int j = 1; j < n; j++)dis[0][j] = min(dis[0][j], dis[ind][j]);
            dis[0][ind] = -1;
        }
        if(rest > 0)return -1;
        return sum;
    }
}