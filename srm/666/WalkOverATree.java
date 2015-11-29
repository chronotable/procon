import java.util.*;
import static java.lang.Math.*;

public class WalkOverATree{
    int n;
    public int maxNodesVisited(int[] parent, int L){
        n = parent.length + 1;
        final int INF = 1<<20;
        int[][] g = new int[n][n];
        for(int i = 0; i < n; i++)Arrays.fill(g[i], INF);
        for(int i = 0; i < n - 1; i++)g[i+1][parent[i]] = g[parent[i]][i+1] = 1;
        for(int k = 0; k < n; k++)for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)
                                                                g[i][j] = min(g[i][j], g[i][k] + g[k][j]);
        int ans = 1;
        for(int i = 0; i < 1; i++)for(int j = 1; j < n; j++){
                //System.out.println(i + " " + j + " = " + g[i][j]);
                int sum = g[i][j] + 1;
                int rest = L - g[i][j];
                if(rest < 0)continue;
                ans = max(ans, min(sum + rest / 2, n));
            }
        return ans;
    }
}
