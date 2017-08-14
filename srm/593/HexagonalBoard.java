import java.util.*;
import static java.lang.Math.*;

public class HexagonalBoard{
    int n;
    char[][] b;
    private static final int[] dy = new int[]{-1, 1, 0, 0, -1, 1};
    private static final int[] dx = new int[]{0, 0, -1, 1, 1, -1};
    boolean in(int y, int x){
        return y>=0 && y < n && x >= 0 && x < n;
    }
    boolean need(int y, int x){
        return in(y, x) && b[y][x] == 'X';
    }

    void dfs(int y, int x, int[][] score, boolean[][] visited){
        boolean[] appear = new boolean[10];
        visited[y][x] = true;
        for(int a = 0; a < dy.length; a++){
            int ny = y + dy[a];
            int nx = x + dx[a];
            if(!need(ny, nx))continue;
            if(visited[ny][nx])appear[score[ny][nx]] = true;
        }
        for(int i = 1; i < appear.length; i++)if(!appear[i]){
                score[y][x] = i;
                break;
            }
        for(int a = 0; a < dy.length; a++){
            int ny = y + dy[a];
            int nx = x + dx[a];
            if(!need(ny, nx))continue;
            if(!visited[ny][nx])dfs(ny, nx, score, visited);
        }
    }
    public int minColors(String[] board){
        n = board.length;
        int ans = 0;
        b = new char[n][];
        for(int i = 0; i < n; i++)b[i] = board[i].toCharArray();
        //for(int i = 0; i < 4; i++)if(can(i))return i;
        int[][] score = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)if(b[i][j] == 'X' && !visited[i][j])
                                                                dfs(i, j, score, visited);
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)ans = max(ans, score[i][j]);
        return min(3, ans);
    }
}