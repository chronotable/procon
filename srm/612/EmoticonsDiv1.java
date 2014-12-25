import java.util.*;
import static java.lang.Math.*;

public class EmoticonsDiv1{
    private static final int INF = 1<<20;
    int s;
    int[][] memo;
    public int printSmiles(int _s){
        s = _s;
        memo = new int[s+1][s+1];
        for(int i = 0; i < memo.length; i++)Arrays.fill(memo[i], INF);
        //return dfs(1, 0);
        memo[1][0] = 0;
        PriorityQueue<E> q = new PriorityQueue<E>();
        q.offer(new E(0, 1, 0));
        while(!q.isEmpty()){
            E e = q.poll();
            int len = e.len, clip = e.clip, cost = e.cost;
            if(memo[len][clip] < cost)continue;
            if(len==s)return cost;
            // paste
            if(clip > 0){
                int nl = len+clip;
                int nc = cost+1;
                if(nl > s){nc += nl-s; nl=s;}
                if(memo[nl][clip] > nc){
                    E f = new E(nc, nl, clip);
                    memo[nl][clip] = nc;
                    q.offer(f);
                }
            }
            // copy
            if(len != clip){
                int ncl = len;
                int nc = cost+1;
                if(memo[len][ncl] > nc){
                    memo[len][ncl] = nc;
                    q.offer(new E(nc, len, ncl));
                }
            }
            // delete
            if(len > 1){
                int nl = len-1;
                int nc = cost+1;
                if(memo[nl][clip] > nc){
                    E f = new E(nc, nl, clip);
                    memo[nl][clip] = nc;
                    q.offer(f);
                } 
            }
        }
        return INF;
    }
}

class E implements Comparable<E>{
    int cost;
    int len;
    int clip;
    E(int c, int l, int cl){
        cost = c; len = l; clip = cl;
    }
    public int compareTo(E e){
        if(this.cost != e.cost)return this.cost-e.cost;
        return this.len-e.len;
    }
}