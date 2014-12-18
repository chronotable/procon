import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            int v = 0;
            for(int i = 0; i < 9; i++){
                String s = sc.next();
                if(s.equals("x"))v = v * 10+ 9;
                else v = v * 10 + Integer.parseInt(s);
            }
            PriorityQueue<Info> q = new PriorityQueue<Info>();
            TreeSet<Integer> ts = new TreeSet<Integer>();
            q.offer(new Info(v, ""));
            final int[] dx = new int[]{1, 0, -1, 0};
            final int[] dy = new int[]{0, -1, 0, 1};
            final char[] d = new char[]{'r', 'u', 'l', 'd'};
            while(!q.isEmpty()){
                Info t = q.poll();
                if(ts.contains(t.state))continue;
                ts.add(t.state);
                if(t.cost == t.dir.length()){
                    System.out.println(t.dir);
                    break;
                }
                int[][] b = new int[3][3];
                int cx = -1, cy = -1;
                for(int i = 8; i >= 0; i--){
                    b[i / 3][i % 3] = t.state % 10;
                    if(t.state % 10 == 9){
                        cy = i / 3;
                        cx = i % 3;
                    }
                    t.state /= 10;
                }
                for(int i = 0; i < dx.length;i++){
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];
                    if(ny >= 3 || ny < 0 || nx >= 3 || nx < 0)continue;
                    b[cy][cx] = b[ny][nx];
                    b[ny][nx] = 9;
                    int ns = calc(b);
                    b[ny][nx] = b[cy][cx];
                    b[cy][cx] = 9;
                    if(ts.contains(ns))continue;
                    q.offer(new Info(ns, t.dir + d[i]));
                }
            }
        }
    }

    int calc(int[][] b){
        int ret = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                ret = ret * 10 + b[i][j];
            }
        }
        return ret;
    }

    class Info implements Comparable<Info>{
        int state;
        int cost;
        String dir;
        Info(int a, String b){
            state = a;
            dir = b;
            int t = state;
            cost = 0;
            for(int i = 0; i < 9; i++){
                if(t % 10 != 9 - i)cost++;
                t /= 10;
            }
            cost += dir.length();
        }
        public int compareTo(Info i){
            return this.cost - i.cost;
        }
    }
}
