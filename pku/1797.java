import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int o = 1; o <= T; o++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<N>[] tbl = new ArrayList[n];
            for(int i = 0; i < n; i++)tbl[i] = new ArrayList<N>();
            for(int i = 0; i < m; i++){
                int s = sc.nextInt()-1;
                int e = sc.nextInt()-1;
                int cap = sc.nextInt();
                tbl[s].add(new N(e, cap));
                tbl[e].add(new N(s, cap));
            }
            int[] dp = new int[n];
            Arrays.fill(dp, -1);
            PriorityQueue<N> q = new PriorityQueue<N>();
            q.offer(new N(0, 1<<25));
            while(!q.isEmpty()){
                N w = q.poll();
                //if(dp[q.pos] >= q.cap)continue;
                if(w.pos == n-1)break;
                for(int i = 0; i < tbl[w.pos].size(); i++){
                    N x = tbl[w.pos].get(i);
                    int c = min(w.cap, x.cap);
                    if(dp[x.pos] < c){
                        dp[x.pos] = c;
                        q.offer(new N(x.pos, c));
                    }
                }
            }
            System.out.printf("Scenario #%d:\n", o);
            System.out.println(dp[n-1]);
            System.out.println();
        }
    }

    class N implements Comparable<N>{
        int pos, cap;
        N(int a, int b){
            pos = a;
            cap = b;
        }
        public int compareTo(N n){
            return n.cap - this.cap;
        }
    }
}
