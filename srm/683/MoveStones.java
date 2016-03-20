import java.util.*;
import static java.lang.Math.*;

public class MoveStones{
    public long get(int[] A, int[] B){
        int n = A.length;
        long as = 0, bs = 0;
        for(int i = 0; i < n; i++){as += A[i]; bs += B[i];}
        if(as != bs)return -1;
        ArrayList<Long> a = new ArrayList<Long>(), b = new ArrayList<Long>();
        long ret = 1l << 60;
        for(int i = 0; i < n; i++){
            a.clear(); b.clear();
            for(int j = 0; j < n; j++){
                a.add((long)A[(i + j) % n]);
                b.add((long)B[(i + j) % n]);
            }
            long sum = 0;
            for(int j = 0; j < n-1; j++){
                long dif = a.get(j) - b.get(j);
                a.set(j + 1, a.get(j + 1) + dif);
                sum += abs(dif);
            }
            ret = min(ret, sum);
        }
        return ret;
    }
}

/*
public class MoveStones{
  public long get(int[] a, int[] b){
    int n = a.length;
    long as = 0, bs = 0;
    for(int i : a)as+=i;
    for(int i : b)bs+=i;
    if(as != bs)return -1;
    int m = 1 + n + n + 1;
    V[] vs = new V[m];
    for(int i = 0; i < m; i++)vs[i] = new V();
    double flow = 0;
    for(int i = 0; i < n; i++)if(a[i] > b[i])flow += a[i] - b[i];
    for(int i = 0; i < n; i++){
      if(a[i] > b[i]){
        vs[0].add(vs[i+1], a[i] - b[i], 0);
        for(int j = 0; j < n; j++)if(a[j] < b[j]){
          int c = n;
          if(i < j)c = min(j - i, n - j + i);
          else c = min(i - j, n - i + j);
          vs[i+1].add(vs[1+n+j], a[i] - b[i], c);
        }
      }else if(a[i] < b[i]){
        vs[1+n+i].add(vs[m-1], b[i] - a[i], 0);
      }
    }
    return (long)(PrimalDualFast.minCostFlow(vs, vs[0], vs[m-1], flow));
  }
}


class PrimalDualFast{
    public static double INF = 1e100;
    public static double minCostFlow(V[] vs, V s, V t, double flow){
        double res = 0;
        while (flow > 0) {
            for(V v : vs)
                v.min = INF;
            PriorityQueue<E> que = new PriorityQueue<E>();
            s.min = 0;
            que.offer(new E(s, 0, 0));
            while (!que.isEmpty()) {
                E crt = que.poll();
                if (crt.cost == crt.to.min) {
                    for (E e : crt.to.es) {
                        double tmp = crt.cost + e.cost + crt.to.h - e.to.h;
                        if (e.cap > 0 && e.to.min > tmp) {
                            e.to.min = tmp;
                            e.to.prev = e;
                            que.offer(new E(e.to, 0, e.to.min));
                        }
                    }
                }
            }
            if (t.min == INF) return -1;
            double d = flow;
            for(E e = t.prev; e != null; e = e.rev.to.prev)
                d = Math.min(d, e.cap);
            for(E e = t.prev; e != null; e = e.rev.to.prev){
                res += d * e.cost;
                e.cap -= d;
                e.rev.cap += d;
            }
            flow -= d;
            for(V v : vs)
                v.h += v.min;
        }
        return res;
    }
}

class V{
    ArrayList<E> es = new ArrayList<E>();
    E prev;
    double min, h;
    void add(V to, double cap, double cost){
        E e = new E(to, cap, cost), rev = new E(this, 0, -cost);
        e.rev = rev; rev.rev = e;
        es.add(e); to.es.add(rev);
    }
}
class E implements Comparable<E>{
    V to;
    E rev;
    double cap, cost;
    E(V to, double cap, double cost){
        this.to = to;
        this.cap = cap;
        this.cost = cost;
    }
    public int compareTo(E o){
        if(this.cost == o.cost)
            return 0;
        return this.cost > o.cost ? 1 : -1;
    }
}
*/
