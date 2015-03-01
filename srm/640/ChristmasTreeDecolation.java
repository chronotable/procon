import java.util.*;
import static java.lang.Math.*;

public class ChristmasTreeDecoration{
    int n, m;
    public int solve(int[] col, int[] x, int[] y){
        n = col.length;
        m = x.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < m; i++){
            x[i]--; y[i]--;
            if(col[x[i]] != col[y[i]])uf.merge(x[i], y[i]);
        }
        Set<Integer> ban = new HashSet<Integer>();
        for(int i = 0; i < n; i++)if(uf.root(i) != i)ban.add(uf.root(i));
        int ans = 0;
        for(int i = 0; i < m; i++){
            if(col[x[i]] == col[y[i]] && !ban.contains(uf.root(x[i])) && !ban.contains(uf.root(y[i])) &&
               uf.merge(x[i], y[i])){
                ans++;
            }
        }
        Set<Integer> s = new HashSet<Integer>();
        for(int i = 0; i < n; i++)s.add(uf.root(i));
        return ans + s.size() - 1;
    }
}

class UnionFind{
    int n;
    int[] parent;
    int[] rank;

    public UnionFind(int _n){
        n = _n;
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int root(int x){
        if(parent[x] != x)
            parent[x] = root(parent[x]);
        return parent[x];
    }

    boolean merge(int x, int y){
        int rx = root(x), ry = root(y);
        if(rx == ry)
            return false;
        if(rank[rx] >= rank[ry]){
            parent[ry] = rx;
            rank[rx] += rank[ry];
        }else{
            parent[rx] = ry;
            rank[ry] += rank[rx];
        }
        return true;
    }

    int getSize(int x){
        return rank[root(x)];
    }
}
