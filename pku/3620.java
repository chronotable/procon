import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        final int[] dx = new int[]{1,0,-1,0};
        final int[] dy = new int[]{0,1,0,-1};
        int mx = 0;
        boolean[][] isl = new boolean[n][m];
        boolean[][] u = new boolean[n][m];
        for(int i = 0; i < k;i++)isl[sc.nextInt()-1][sc.nextInt()-1] = true;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < m;j++){
                if(!isl[i][j] || u[i][j])continue;
                Point[] q = new Point[100000];
                int p = 0;
                int sum = 0;
                q[p++] = new Point(i,j);
                for(int cur = 0; cur < p;cur++){
                    Point tp = q[cur];
                    if(u[tp.r][tp.c])continue;
                    sum++;
                    u[tp.r][tp.c] = true;
                    for(int z = 0; z < dx.length;z++){
                        int ny = tp.r + dy[z];
                        int nx = tp.c + dx[z];
                        if(ny < 0 || ny >= n || nx < 0 || nx >= m ||
                           !isl[ny][nx] || u[ny][nx])continue;
                        q[p++] = new Point(ny, nx);
                    }
                }
                mx = max(mx, sum);
            }
        }
        System.out.println(mx);
    }

    class Point{
        int r,c;
        Point(int a, int b){
            r=a;c=b;
        }
    }
}
