import java.util.*;
import static java.lang.Math.*;

public class Egalitarianism{
    public int maxDifference(String[] isFriend, int d){
        final int n = isFriend.length;
        final int INF = 1<<20;
        int[][] dis = new int[n][n];
        for(int i = 0; i < n; i++){Arrays.fill(dis[i], INF);dis[i][i] = 0;}
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)if(isFriend[i].charAt(j) == 'Y')dis[i][j] = 1;
        for(int k = 0; k < n; k++)for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)
                                                                dis[i][j] = min(dis[i][j], dis[i][k] + dis[k][j]);
        int mx = 0;
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)mx = max(mx, dis[i][j]);
        if(mx == INF)return -1;
        return mx * d;
    }
}
