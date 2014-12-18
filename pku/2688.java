import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    final int M = 10000000;

    int calcDis(char[][] r, ArrayList<Integer> x, ArrayList<Integer> y,
                int a, int b){
        int h = r.length;
        int w = r[0].length;
        int[][] dp = new int[h][w];
        for(int i = 0; i < h; i++)Arrays.fill(dp[i], M);
        dp[y.get(a)][x.get(a)] = 0;
        int ey = y.get(b);
        int ex = x.get(b);
        PriorityQueue<E> q = new PriorityQueue<E>();
        q.offer(new E(x.get(a), y.get(a), 0, ex, ey));
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};
        while(!q.isEmpty()){
            E t = q.poll();
            if(dp[t.y][t.x] != t.d)continue;
            if(t.y == ey && t.x == ex)break;
            for(int i = 0; i < dx.length; i++){
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                if(nx < 0 || nx >= w || ny < 0 || ny >= h ||
                   r[ny][nx] == 'x' || dp[ny][nx] <= t.d + 1)continue;
                dp[ny][nx] = t.d + 1;
                q.offer(new E(nx, ny, t.d + 1,ex, ey));
            }
        }
        return dp[ey][ex];
    }

    int ans;

    void tra(boolean[] u,int[][] dis,
             int cur, int num, int total){
        if(num == u.length){
            ans = min(ans, total);
            return;
        }
        if(total >= ans)return;
        for(int i = 0; i < u.length; i++){
            if(!u[i] && dis[cur][i] != M){
                u[i] = true;
                tra(u, dis, i, num+1, total + dis[cur][i]);
                u[i] = false;
            }
        }
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int w = sc.nextInt();
            int h = sc.nextInt();
            if(w+h==0)break;
            //int sx = -1, sy = -1, si = -1;
            ArrayList<Integer> x = new ArrayList<Integer>();
            ArrayList<Integer> y = new ArrayList<Integer>();
            char[][] r = new char[h][w];
            for(int i = 0; i < h; i++){
                String s = sc.next();
                r[i] = s.toCharArray();
                for(int j = 0; j < w; j++){
                    if(r[i][j] == 'o'){
                        x.add(0,j); y.add(0,i);
                    }else if(r[i][j] == '*'){
                        x.add(j); y.add(i);
                    }
                }
            }
            int n = x.size();
            int[][] dis = new int[n][n];
            int mx = -1;
            loop:
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    dis[i][j] = dis[j][i] = calcDis(r,x,y,i,j);
                    mx = max(mx, dis[i][j]);
                    if(mx == M)break loop;
                }
            }
            if(mx == M){
                System.out.println( -1);
                continue;
            }
            boolean[] u = new boolean[n];
            u[0] = true;
            ans = M;
            tra(u,dis,0,1,0);
            if(ans == M)ans = -1;
            System.out.println(ans);
        }
    }

    class E implements Comparable<E>{
        int x, y, d,v;
        E(int a, int b, int c, int ex, int ey){
            x = a;
            y = b;
            d = c;
            v = d + abs(x-ex) + abs(y-ey);
        }
        public int compareTo(E e){
            return this.v - e.v;
        }
    }
}
