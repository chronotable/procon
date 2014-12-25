import java.util.*;
import static java.lang.Math.*;

public class MaxMinTreeGame{
    public int findend(int[] edges, int[] costs){
        int n = costs.length;
        int[] deg = new int[n];
        for(int i = 0; i < n-1; i++){
            deg[i+1]++;
            deg[edges[i]]++;
        }
        int mx = 0;
        for(int i = 0; i < n; i++)if(deg[i] == 1)mx = max(mx, costs[i]);
        return mx;
    }
}