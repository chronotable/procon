import java.util.*;
import static java.lang.Math.*;

public class MultiplicationTable2{
    public int minimalGoodSet(int[] table){
        int n = (int)sqrt(table.length);
        int[][] t = new int[n][n];
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)t[i][j] = table[i*n+j];
        int ans = n;
        for(int i = 0; i < n; i++){
            Set<Integer> s = new HashSet<Integer>();
            s.add(i);
            Queue<Integer> q = new LinkedList<Integer>();
            q.offer(i);
            Set<Integer> x = new HashSet<Integer>();
            while(!q.isEmpty()){
                int v = q.poll();
                s.add(v);
                x.clear();
                for(int w : s){
                    if(!s.contains(t[v][w]) && !x.contains(t[v][w])){q.offer(t[v][w]); x.add(t[v][w]);}
                    if(!s.contains(t[w][v]) && !x.contains(t[w][v])){q.offer(t[w][v]); x.add(t[w][v]);}
                }
                for(int y : x)s.add(y);
            }
            ans = min(ans, s.size());
        }
        return ans;
    }
}
