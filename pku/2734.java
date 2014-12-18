import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        final int[] kdx = new int[]{2,1,-1,-2,-2,-1,1,2};
        final int[] kdy = new int[]{1,2,2,1,-1,-2,-2,-1};
        final int[] qdx = new int[]{1,1,0,-1,-1,-1,0,1};
        final int[] qdy = new int[]{0,1,1,1,0,-1,-1,-1};
        for(int o = 1;;o++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            if(r+c==0)break;
            int[][] u = new int[r][c];
            int qn = sc.nextInt();
            int[] qx = new int[qn];
            int[] qy = new int[qn];
            for(int i = 0; i < qn; i++){
                qy[i] = sc.nextInt() - 1;
                qx[i] = sc.nextInt() - 1;
            }
            int kn = sc.nextInt();
            int[] kx = new int[kn];
            int[] ky = new int[kn];
            for(int i = 0; i < kn; i++){
                ky[i] = sc.nextInt() - 1;
                kx[i] = sc.nextInt() - 1;
                u[ky[i]][kx[i]] = -1;
            }
            int pn = sc.nextInt();
            for(int i = 0; i < pn; i++){
                u[sc.nextInt()-1][sc.nextInt()-1] = -1;
            }
            for(int i = 0; i < qn; i++){
                for(int j = 0; j < qdx.length; j++){
                    int cx = qx[i];
                    int cy = qy[i];
                    int dx = qdx[j];
                    int dy = qdy[j];
                    while(cx >= 0 && cx < c && cy >= 0 && cy < r &&
                          u[cy][cx] >= 0){
                        u[cy][cx] = 1;
                        cy += dy;
                        cx += dx;
                    }
                }
            }
            for(int i = 0; i < kn; i++){
                for(int j = 0; j < kdx.length; j++){
                    int ny = ky[i] + kdy[j];
                    int nx = kx[i] + kdx[j];
                    if(nx >= 0 && nx < c && ny >= 0 && ny < r)
                        u[ny][nx] = 1;
                }
            }
            int ans = 0;
            for(int i = 0; i < r; i++)
                for(int j = 0; j < c; j++)
                    if(u[i][j] == 0) ans++;
            System.out.printf("Board %d has %d safe squares.\n", o, ans);
        }
    }
}
