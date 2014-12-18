import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    int ans = 0;

    void select(char[][] f, boolean[][] u, int prev, int sum, int jersey){
        if(sum == 7){
            if(jersey > 3)check(f, u);
            return;
        }
        int lim = 25 - (7 - sum);
        for(int i = prev + 1; i <= lim; i++){
            int y = i / 5;
            int x = i % 5;
            u[y][x] = true;
            select(f, u, i, sum+1, jersey + (f[y][x] == 'J' ? 1 : 0));
            u[y][x] = false;
        }
    }

    void check(char[][] f, boolean[][] u){
        boolean[][] v = new boolean[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(u[i][j]){
                    if(countConnection(u, v, i, j) != 7)return;
                    ans++;
                    return;
                }
            }
        }
    }

    int countConnection(boolean[][] u, boolean[][] v, int y, int x){
        final int[] dx = new int[]{1,0,-1,0};
        final int[] dy = new int[]{0,1,0,-1};
        v[y][x] = true;
        int sum = 0;
        for(int i = 0; i < dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 ||
               !u[ny][nx] || v[ny][nx])continue;
            sum += countConnection(u, v, ny, nx);
        }
        return sum + 1;
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        char[][] f = new char[5][5];
        for(int i = 0; i < 5; i++){
            String s = sc.next();
            f[i] = s.toCharArray();
        }
        boolean[][] u = new boolean[5][5];
        ans = 0;
        select(f, u, -1, 0, 0);
        System.out.println(ans);
    }
}
