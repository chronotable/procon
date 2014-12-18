import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int N = sc.nextInt();
        int B = sc.nextInt();
        int[][] dp = new int[L+1][B+1];
        ArrayList<Dest>[] next = new ArrayList[L+1];
        for(int i = 0; i <= L; i++)next[i] = new ArrayList<Dest>();
        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            int w = sc.nextInt();
            int f = sc.nextInt();
            int c = sc.nextInt();
            next[x].add(new Dest(x+w, f, c));
        }
        Queue<V> q = new LinkedList<V>();
        q.offer(new V(0, 0, 0));
        while(!q.isEmpty()){
            V v = q.poll();
            if(dp[v.cur][v.cost] > v.fun)continue;
            for(int i = 0; i < next[v.cur].size(); i++){
                Dest d = next[v.cur].get(i);
                if(d.c + v.cost <= B &&
                   dp[d.d][d.c + v.cost] < v.fun + d.f){
                    dp[d.d][d.c + v.cost] = v.fun + d.f;
                    q.offer(new V(d.d, v.fun + d.f, d.c + v.cost));
                }
            }
        }
        int ans = 0;
        for(int i = 0; i <= B; i++)ans = max(ans, dp[L][i]);
        System.out.println(ans == 0 ? -1 : ans);
    }

    class Dest{
        int d, f, c;
        Dest(int _d, int _f, int _c){
            d = _d;
            f = _f;
            c = _c;
        }
    }

    class V{
        int cur, fun, cost;
        V(int a, int b, int c){
            cur = a;
            fun = b;
            cost = c;
        }
    }
}
