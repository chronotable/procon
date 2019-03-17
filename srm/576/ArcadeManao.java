import java.util.*;
import static java.lang.Math.*;

public class ArcadeManao{
    public int shortestLadder(String[] level, int cr, int cc){
        cc--; cr--;
        final int n = level.length;
        final int m = level[0].length();
        char[][] f = new char[n][m];
        for(int i = 0; i < n; i++)f[i] = level[i].toCharArray();
        for(int l = 0; l < n; l++){
            boolean[][] v = new boolean[n][m];
            Queue<Integer> q = new LinkedList<Integer>();
            v[cr][cc] = true;
            q.offer(cr*m+cc);
            while(!q.isEmpty()){
                int val = q.poll();
                int y = val / m;
                int x = val % m;
                if(y == n-1)return l;
                for(int dx = -1; dx <= 1; dx+=2){
                    int nx = x + dx;
                    if(nx >= 0 && nx < m && f[y][nx] == 'X' && !v[y][nx]){v[y][nx] = true; q.offer(y*m+nx);}
                }
                for(int dy = -l; dy <= l; dy++){
                    int ny = y + dy;
                    if(ny >= 0 && ny < n && f[ny][x] == 'X' && !v[ny][x]){v[ny][x] = true; q.offer(ny*m+x);}
                }
            }
        }
        return n;
    }
}
