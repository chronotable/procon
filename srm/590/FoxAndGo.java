import java.util.*;

public class FoxAndGo{
    int place(char[][] b, int y, int x){
        final int n = b.length;
        final int m = n*n;
        b[y][x] = 'x';
        int ret = 0;
        final int[] dx = new int[]{1, 0, -1, 0};
        final int[] dy = new int[]{0, 1, 0, -1};
        // components
        UnionFind uf = new UnionFind(m);
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)if(b[i][j] == 'o'){
                    final int id = i * n + j;
                    for(int a = 0; a < dx.length; a++){
                        int ny = i + dy[a];
                        int nx = j + dx[a];
                        if(ny < 0 || ny >= n || nx < 0 || nx >= n)continue;
                        if(b[ny][nx] == 'o')uf.merge(id, ny * n + nx);
                    }
                }
        int[] freq = new int[m];
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)if(b[i][j] == 'o')freq[uf.root(i*n+j)]++;
    
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)if(b[i][j] == 'o'){
                    boolean safe = false;
                    for(int a = 0; a < dx.length; a++){
                        int ny = i + dy[a];
                        int nx = j + dx[a];
                        if(ny < 0 || ny >= n || nx < 0 || nx >= n)continue;
                        if(b[ny][nx] == '.')safe = true;
                    }
                    if(safe)freq[uf.root(i*n+j)] = 0;
                }
        for(int i = 0; i < m; i++)ret += freq[i];
        b[y][x] = '.';
        return ret;
    }
    public int maxKill(String[] board){
        final int n = board.length;
        char[][] b = new char[n][];
        for(int i = 0; i < n; i++)b[i] = board[i].toCharArray();
        int ret = 0;
        for(int i = 0; i < n; i++)for(int j = 0; j < n; j++)if(b[i][j] == '.')ret = Math.max(ret, place(b, i, j));
        return ret;
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

    void merge(int x, int y){
        int rx = root(x), ry = root(y);
        if(rx == ry)
            return;
        if(rank[rx] >= rank[ry]){
            parent[ry] = rx;
            rank[rx] += rank[ry];
        }else{
            parent[rx] = ry;
            rank[ry] += rank[rx];
        }
    }

    int getSize(int x){
        return rank[root(x)];
    }
}
