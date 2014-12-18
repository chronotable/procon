import java.util.*;
import static java.lang.Math.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        try{
            new Main().run();
        }catch (Exception e){

        }
    }

    void run() throws Exception{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = sc.readLine().split(" ");
        int n = Integer.parseInt(ip[0]);
        int p = Integer.parseInt(ip[1]);
        int t = Integer.parseInt(ip[2]);
        Edge[] es = new Edge[p];
        for(int i = 0; i < p; i++){
            ip = sc.readLine().split(" ");
            int s = Integer.parseInt(ip[0]);
            int e = Integer.parseInt(ip[1]);
            int len = Integer.parseInt(ip[2]);
            es[i] = new Edge(s-1,e-1,len);
        }
        Arrays.sort(es);
        int l = 1;
        int r = p;
        int m;
        int ans = 1000000000;
        for(;l <= r;){
            m = (l+r) / 2;
            int[][] con = new int[n+2][n+2];
            con[0][1] = 10000;
            for(int i = 0; i < m; i++){
                con[es[i].s+1][es[i].e+1]++;
                con[es[i].e+1][es[i].s+1]++;
            }
            con[n][n+1] = 10000;
            Dinic d = new Dinic(con);
            int mf = d.maxFlow();
            if(mf >= t){
                r = m-1;
                if(mf == t)ans = min(ans, es[m-1].len);
            }else{
                l = m+1;
            }
        }
        System.out.println(ans);
    }
}


class Edge implements Comparable<Edge>{
    int s,e;
    int len;
    Edge(int a, int b, int c){
        s = a;
        e = b;
        len = c;
    }
    public int compareTo(Edge e){
        return this.len - e.len;
    }
}


class Dinic{
    int n, s, t;
    int[][] cap;
    int[][] flow;
    int[] levels;
    boolean[] finished;
    private static final int INF = Integer.MAX_VALUE;
    Dinic(int[][] cp){
        cap = cp;
        n = cp.length;
        s = 0;
        t = n-1;
        flow = new int[n][n];
        levels = new int[n];
        finished = new boolean[n];
    }
    int residue(int i, int j){
        return cap[i][j] - flow[i][j];
    }
    void levelize(){
        Arrays.fill(levels, -1);
        Queue<Integer> q = new LinkedList<Integer>();
        levels[s] = 0; q.offer(s);
        while(!q.isEmpty()){
            int here = q.poll();
            for(int i = 0; i < n;i++){
                if(levels[i] < 0 && residue(here, i) > 0){
                    levels[i] = levels[here] + 1;
                    q.offer(i);
                }
            }
        }
    }
    int augment(int here, int cur){
        if(here == t || cur == 0){
            return cur;
        }
        if(finished[here])return 0;
        finished[here] = true;
        for(int i = 0;i < n;i++){
            if(levels[i] > levels[here]){
                int f = augment(i, min(cur, residue(here, i)));
                if(f > 0){
                    flow[here][i] += f;
                    flow[i][here] -= f;
                    finished[here] = false;
                    return f;
                }
            }
        }
        return 0;
    }
    int maxFlow(){
        //for(int i = 0; i < n;i++)Arrays.fill(flow[i], 0);
        int total = 0;
        for(boolean cont = true; cont;){
            cont = false;
            levelize();
            Arrays.fill(finished, false);
            for(int f; (f = augment(s, INF)) > 0; cont = true)
                total += f;
        }
        return total;
    }
}
