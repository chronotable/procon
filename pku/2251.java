import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        final int MAX = 100000000;
        for(;;){
            int l = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            if(l+h+w==0)break;
            int[][][] dp = new int[l][h][w];
            char[][][] d = new char[l][h][w];
            int sz = -1, sy = -1, sx = -1;
            int ez = -1, ey = -1, ex = -1;
            for(int i = 0; i < l;i++)
                for(int j = 0; j < h;j++)
                    Arrays.fill(dp[i][j], MAX);
            for(int i = 0; i < l;i++){
                for(int j = 0; j < h;j++){
                    String s = sc.next();
                    for(int k = 0; k < w;k++){
                        d[i][j][k] = s.charAt(k);
                        if(d[i][j][k] == 'S'){
                            sz = i; sy = j; sx = k;
                        }else if(d[i][j][k] == 'E'){
                            ez = i; ey = j; ex = k;
                        }
                    }
                }
            }
            Node[] q = new Node[1000000];
            int qsize = 0;
            int cur = 0;
            q[qsize++] = new Node(sz, sy, sx, 0);
            int[] dx = new int[]{1,0,-1,0};
            int[] dy = new int[]{0,1,0,-1};
            for(;cur < qsize;cur++){
                Node n = q[cur];
                if(dp[n.z][n.y][n.x] <= n.dis)continue;
                dp[n.z][n.y][n.x] = n.dis;
                for(int i = 0; i < dx.length;i++){
                    int nx = n.x + dx[i];
                    int ny = n.y + dy[i];
                    if(nx < 0 || nx >= w || ny < 0 || ny >= h ||
                       d[n.z][ny][nx] == '#' ||
                       dp[n.z][ny][nx] <= n.dis + 1)continue;
                    q[qsize++] = new Node(n.z, ny, nx, n.dis+1);
                }
                int nz = n.z + 1;
                if(nz < l && d[nz][n.y][n.x] != '#' &&
                   dp[nz][n.y][n.x] > n.dis + 1)
                    q[qsize++] = new Node(nz, n.y, n.x, n.dis+1);
                nz = n.z - 1;
                if(nz >= 0 && d[nz][n.y][n.x] != '#' &&
                   dp[nz][n.y][n.x] > n.dis + 1)
                    q[qsize++] = new Node(nz, n.y, n.x, n.dis+1);
            }
            if(dp[ez][ey][ex] == MAX)
                System.out.println("Trapped!");
            else
                System.out.println("Escaped in " + dp[ez][ey][ex] +
                                   " minute(s).");
        }
    }
    class Node{
        int z,y,x,dis;
        Node(int a, int b, int c, int d){
            z = a;
            y = b;
            x = c;
            dis = d;
        }
    }
}
