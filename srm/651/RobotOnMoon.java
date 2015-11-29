import java.util.*;
import static java.lang.Math.*;

public class RobotOnMoon{
    int w, h;
    char[][] b;
    boolean in(int y, int x){
        return y >= 0 && y < h && x >= 0 && x < w;
    }
    int calc(int sy, int sx, int dy, int dx){
        int[][] cost = new int[h][w];
        for(int i = 0; i < h; i++)Arrays.fill(cost[i], -1);
        cost[sy][sx] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(sy * w + sx);
        int ret = 0;
        while(!q.isEmpty()){
            int v = q.poll();
            int y = v / w;
            int x = v % w;
            int c = cost[y][x];
            for(int i = 0; i < 2; i++){
                int ny = y + (i==0?dy:0), nx = x + (i==1?dx:0);
                if(!in(ny, nx))ret = max(ret, c);
                else if(cost[ny][nx] < 0){cost[ny][nx] = c + 1; q.offer(ny * w + nx);}
            }
        }
        return ret;
    }
    public int longestSafeCommand(String[] board){
        h = board.length;
        w = board[0].length();
        b = new char[h][];
        for(int i = 0; i < h; i++)b[i] = board[i].toCharArray();
        int sy = -1, sx = -1;
        for(int i = 0; i < h; i++)for(int j = 0; j < w; j++)if(b[i][j] == 'S'){
                    sy = i; sx = j; break;
                }
        boolean endless = false;
        for(int i = 0; i < h; i++)if(b[i][sx] == '#')endless = true;
        for(int j = 0; j < w; j++)if(b[sy][j] == '#')endless = true;
        if(endless)return -1;
        int ans = 0;
        for(int dy = -1; dy <= 1; dy += 2)for(int dx = -1; dx <= 1; dx += 2){
                int ay = dy==1?sy:h-sy-1;
                int ax = dx==1?sx:w-sx-1;
                ans = max(ans, calc(sy, sx, dy, dx) + ay + ax);
            }
        return ans;
    }
}
