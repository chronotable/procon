import java.util.*;
import static java.lang.Math.*;

public class TheGridDivTwo{
    public int find(int[] x, int[] y, int s){
        int n = x.length;
        final int BX = 1000;
        final int BY = 1000;
        final int W = BX*2+1;
        final int H = BY*2+1;
        boolean[][] u = new boolean[H][W];
        u[BY][BX] = true;
        Queue<E> q = new LinkedList<E>();
        q.offer(new E(BY, BX, 0));
        final int[] dx = new int[]{1, 0, -1, 0};
        final int[] dy = new int[]{0, 1, 0, -1};
        boolean[][] b = new boolean[H][W];
        for(int i = 0; i < n; i++)b[y[i]+BY][x[i]+BX] = true;
        while(!q.isEmpty()){
            E e = q.poll();
            if(e.step == s)
                continue;
            for(int a = 0; a < dx.length; a++){
                int ny = e.y + dy[a];
                int nx = e.x + dx[a];
                if(u[ny][nx] || b[ny][nx])
                    continue;
                u[ny][nx] = true;
                q.offer(new E(ny, nx, e.step + 1));
            }
        }
        int ret = 0;
        for(int i = 0; i < H; i++)for(int j = BX; j < W; j++)if(u[i][j])ret = max(ret, j - BX);
        return ret;
    }
}

class E{
    int y, x, step;
    E(int _y, int _x, int _s){
        y = _y;
        x = _x;
        step = _s;
    }
}
