import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        try{
            new Main().run();
        }catch(Exception e){

        }
    }

    void run() throws Exception{
        //Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line = sc.readLine();
        String[] ls = line.split(" ");
        int N = Integer.parseInt(ls[0]);
        int R = Integer.parseInt(ls[1]);
        ArrayList<To>[] tbl = new ArrayList[N];
        for(int i = 0; i < N; i++)
            tbl[i] = new ArrayList<To>();
        for(int i = 0; i < R; i++){
            line = sc.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken())- 1;
            int dis = Integer.parseInt(st.nextToken());
            tbl[from].add(new To(to, dis));
            tbl[to].add(new To(from, dis));
        }
        long[][] dp = new long[N][2];
        for(int i = 0; i < N; i++)Arrays.fill(dp[i], Long.MAX_VALUE);
        PriorityQueue<To> q = new PriorityQueue<To>();
        //dp[0][0] = dp[0][1] = 0;
        q.offer(new To(0, 0));
        loop:
        while(!q.isEmpty()){
            To cur = q.poll();
            int d = cur.dis;

            if(dp[cur.dst][0] > d){
                //dp[cur.dst][1] = dp[cur.dst][0];
                dp[cur.dst][0] = d;
            }else if(dp[cur.dst][1] > d){
                dp[cur.dst][1] = d;
            }else{
                continue;
            }

            if(dp[N-1][1] != Long.MAX_VALUE)break;

            for(int i = 0; i < tbl[cur.dst].size(); i++){
                To t = tbl[cur.dst].get(i);
                int nd = d + t.dis;
                if(dp[t.dst][1] > nd) q.offer(new To(t.dst, nd));
                /*
                if(dp[t.dst][0] > nd){
                    //dp[t.dst][1] = dp[t.dst][0];
                    dp[t.dst][0] = nd;
                    //if(dp[N-1][1] != Long.MAX_VALUE)break loop;
                    q.offer(new To(t.dst, -nd));
                }
                else if(dp[t.dst][1] > nd){
                    dp[t.dst][1] = nd;
                    q.offer(new To(t.dst, -nd));
                    //if(t.dst == N-1)break loop;
                }
                */
            }
        }
        if(dp[N-1][1] == Long.MAX_VALUE)System.out.println(-1);
        else System.out.println(dp[N-1][1]);
    }

    class To implements Comparable<To>{
        int dst;
        int dis;
        To(int a, int b){
            dst = a;
            dis = b;
        }
        public int compareTo(To t){
            return this.dis - t.dis;
        }
    }
}
