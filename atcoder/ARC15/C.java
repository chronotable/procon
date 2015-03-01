import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class C{
    public static void main(String[] args) throws Exception{
        new C().run();
    }

    int n;
    String[] large;
    int[] m;
    String[] small;
    ArrayList<String> ua = new ArrayList<String>();
    HashMap<String, Integer> s2i = new HashMap<String, Integer>();
    HashMap<Integer, String> i2s = new HashMap<Integer, String>();
    double[][] graph;

    void run() throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        large = new String[n];
        m = new int[n];
        small = new String[n];
        HashSet<String> us = new HashSet<String>();
        for(int i = 0; i < n; i++){
            large[i] = sc.next();
            m[i] = sc.nextInt();
            small[i] = sc.next();
            us.add(large[i]); us.add(small[i]);
        }
        for(String s : us)
            ua.add(s);
        int node = ua.size();
        for(int i = 0; i < node; i++){
            s2i.put(ua.get(i), i);
            i2s.put(i, ua.get(i));
        }
        graph = new double[node][node];
        for(int i = 0; i < n; i++){
            int li = s2i.get(large[i]), si = s2i.get(small[i]);
            graph[li][si] = m[i];
            graph[si][li] = 1.0 / m[i];
        }
        double ans = 0;
        int start = -1, end = -1;
        for(int i = 0; i < node; i++){
            double mx = 0;
            int where = -1;
            double[] memo = new double[node];
            PriorityQueue<E> q = new PriorityQueue<E>();
            q.offer(new E(1, i));
            memo[i] = 1;
            while(!q.isEmpty()){
                E e = q.poll();
                if(memo[e.pos] > e.value)
                    continue;
                if(mx < e.value){
                    mx = e.value;
                    where = e.pos;
                }
                for(int j = 0; j < node; j++){
                    if(graph[e.pos][j] == 0)
                        continue;
                    double nv = e.value * graph[e.pos][j];
                    if(memo[j] < nv){
                        memo[j] = nv;
                        q.offer(new E(nv, j));
                    }
                }
            }
            if(ans < mx){
                ans = mx;
                start = i; end = where;
            }
        }
        System.out.printf("1%s=%d%s\n", i2s.get(start), (int)ans, i2s.get(end));
    }
}

class E implements Comparable<E>{
    double value;
    int pos;
    E(double a, int b){
        value = a;
        pos = b;
    }
    @Override
    public int compareTo(E e){
        return Double.compare(e.value, this.value);
    }
}
