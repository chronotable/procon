import java.util.*;
import static java.lang.Math.*;

public class ShadowSculpture{
    int n;
    int[][][] c;
    boolean[][][] u;
    void fill(int x, int y, int z, int val){
        if(z < 0)     for(int i = 0; i < n; i++)c[x][y][i] = val;
        else if(y < 0)for(int i = 0; i < n; i++)c[x][i][z] = val;
        else if(x < 0)for(int i = 0; i < n; i++)c[i][y][z] = val;
    }
    void connect(int sx, int sy, int sz){
        final int[] dx = new int[]{1, 0, -1, 0, 0, 0};
        final int[] dy = new int[]{0, 1, 0, -1, 0, 0};
        final int[] dz = new int[]{0, 0, 0, 0, 1, -1};
        final int BASE = 100;
        if(c[sx][sy][sz] == 0)return;
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)Arrays.fill(u[i][j], false);
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(sx*BASE*BASE + sy*BASE + sz);
        u[sx][sy][sz] = true;
        while(!q.isEmpty()){
            int v = q.poll();
            int z = v % BASE; v /= BASE;
            int y = v % BASE; v /= BASE;
            int x = v % BASE;
            for(int a = 0; a < 6; a++){
                int nx = x + dx[a], ny = y + dy[a], nz = z + dz[a];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || nz < 0 || nz >= n || c[nx][ny][nz] == 0 || u[nx][ny][nz])continue;
                u[nx][ny][nz] = true;
                q.offer(nx*BASE*BASE + ny*BASE + nz);
            }
        }
    }
    public String possible(String[] XY, String[] YZ, String[] ZX){
        n = XY.length;
        c = new int[n][n][n];
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)Arrays.fill(c[i][j], 1);
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++){
                if(XY[i].charAt(j) == 'N')fill(i, j, -1, 0);
                if(YZ[i].charAt(j) == 'N')fill(-1, i, j, 0);
                if(ZX[i].charAt(j) == 'N')fill(j, -1, i, 0);
            }
        u = new boolean[n][n][n];
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)for(int k = 0; k < n; k++){
                    connect(i, j, k);
                    boolean ok = true;
                    for(int x = 0; x < n; x++)for(int y = 0; y < n; y++){
                            int block = 0;
                            for(int z = 0; z < n; z++)if(u[x][y][z] && c[x][y][z] > 0)block++;
                            if(XY[x].charAt(y) == 'Y' && block==0)ok = false;
                        }
                    for(int y = 0; y < n; y++)for(int z = 0; z < n; z++){
                            int block = 0;
                            for(int x = 0; x < n; x++)if(u[x][y][z] && c[x][y][z] > 0)block++;
                            if(YZ[y].charAt(z) == 'Y' && block==0)ok = false;
                        }
                    for(int z = 0; z < n; z++)for(int x = 0; x < n; x++){
                            int block = 0;
                            for(int y = 0; y < n; y++)if(u[x][y][z] && c[x][y][z] > 0)block++;
                            if(ZX[z].charAt(x) == 'Y' && block==0)ok = false;
                        }
                    if(ok)return "Possible";
                }
        return "Impossible";
    }
}
