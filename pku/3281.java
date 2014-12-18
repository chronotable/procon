import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int tot = 2 + f + n + n + d;
        V[] tbl = new V[tot];
        for(int i = 0; i < tot; i++)tbl[i] = new V();
        for(int i = 0; i < f;i++)tbl[0].add(tbl[1+i], 1);
        for(int i = 0; i < n;i++)
            tbl[1+f+i].add(tbl[1+f+n+i], 1);
        for(int i = 0; i < d;i++)
            tbl[1+f+n+n+i].add(tbl[tot-1], 1);
        for(int i = 0; i < n;i++){
            int fn = sc.nextInt();
            int dn = sc.nextInt();
            for(int j = 0; j < fn;j++){
                int v = sc.nextInt()-1;
                tbl[1+v].add(tbl[1+f+i], 1);
            }
            for(int j = 0; j < dn;j++){
                int v = sc.nextInt()-1;
                tbl[1+f+n+i].add(tbl[1+f+n+n+v], 1);
            }
        }
        System.out.println(SDinic.dinic(tbl[0], tbl[tot-1]));
    }
}


class SDinic{

    static final int INF = Integer.MAX_VALUE;

    static int dinic(V s, V t){
        int flow = 0;
        for(int p = 1; ; p++){
            Queue<V> que = new LinkedList<V>();
            s.level = 0;
            s.p = p;
            que.offer(s);
            while(!que.isEmpty()){
                V v = que.poll();
                v.iter = v.es.size()-1;
                for(E e : v.es)
                    if(e.to.p < p && e.cap > 0){
                        e.to.level = v.level + 1;
                        e.to.p = p;
                        que.offer(e.to);
                    }
            }
            if(t.p < p)
                return flow;
            for(int f; (f = dfs(s, t, INF)) > 0;)
                flow += f;
        }
    }

    static int dfs(V v, V t, int f){
        if(v == t)
            return f;
        for(; v.iter >= 0; v.iter--){
            E e = v.es.get(v.iter);
            if(v.level < e.to.level && e.cap > 0){
                int d = dfs(e.to, t, Math.min(f, e.cap));
                if(d > 0){
                    e.cap -= d;
                    e.rev.cap += d;
                    return d;
                }
            }
        }
        return 0;
    }
}

class V{
    ArrayList<E> es = new ArrayList<E>();
    int level, p, iter;
    void add(V to, int cap){
        E e = new E(to, cap), rev = new E(this, 0);
        e.rev = rev; rev.rev = e;
        es.add(e); to.es.add(rev);
    }
}

class E{
    V to;
    E rev;
    int cap;
    E(V to, int cap){
        this.to = to;
        this.cap = cap;
    }
}
