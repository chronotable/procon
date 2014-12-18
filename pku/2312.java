import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        while(true){
            int h = sc.nextInt();
            int w = sc.nextInt();
            if(h+w==0)break;
            char[][] f = new char[h][w];
            int yx = 0, yy = 0, tx = 0, ty = 0;
            for(int i = 0; i < h;i++){
                String s = sc.next();
                for(int j = 0; j < s.length();j++){
                    f[i][j] = s.charAt(j);
                    if(f[i][j] == 'Y'){
                        yy = i;yx = j;
                    }else if(f[i][j] == 'T'){
                        ty = i; tx = j;
                    }
                }
            }
            int[][] dp = new int[h][w];
            for(int i = 0; i < h;i++)Arrays.fill(dp[i], 1<<20);
            //dp[yy][yx] = 0;
            PriorityQueue<Info> q = new PriorityQueue<Info>();
            q.offer(new Info(yy, yx, 0));
            int[] dx = new int[]{1,0,-1,0};
            int[] dy = new int[]{0,1,0,-1};
            while(!q.isEmpty()){
                Info el = q.poll();
                if(dp[el.y][el.x] <= el.cost)continue;
                dp[el.y][el.x] = el.cost;
                for(int i = 0; i < dx.length; i++){
                    int nx = el.x + dx[i];
                    int ny = el.y + dy[i];
                    if(nx < 0 || nx >= w || ny < 0 || ny >= h)continue;
                    if(f[ny][nx] == 'R' || f[ny][nx] == 'S') continue;
                    int nc = el.cost;
                    if(f[ny][nx] == 'E' || f[ny][nx] == 'T')nc++;
                    if(f[ny][nx] == 'B')nc += 2;
                    if(dp[ny][nx] <= nc)continue;
                    q.offer(new Info(ny, nx, nc));
                }
            }
            if(dp[ty][tx] == 1<<20)System.out.println(-1);
            else System.out.println(dp[ty][tx]);
        }
    }
}

class Info implements Comparable<Info>{
    int y,x,cost;
    Info(int a, int b, int c){
        y = a;
        x = b;
        cost = c;
    }
    public int compareTo(Info i){
        return this.cost - i.cost;
    }
}
