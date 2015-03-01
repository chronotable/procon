import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args) throws Exception{
        new Main().run();
    }

    int n, m, k;
    char[] c;
    int[][] g;

    ArrayList<ArrayList<Integer>> ss;
    ArrayList<Integer> ord;
    int sn;
    int[] si;
    int[][] sg;
    String[] str;
    private static final String fail = "@";
    String[][] memo;

    String dfs(int cur, int rest){
        if(memo[cur][rest] != null)
            return memo[cur][rest];
        //int sci = ord.get(cur);
        String ret = null;
        int size = str[cur].length();
        if(size >= rest)
            ret = str[cur].substring(0, rest);
        for(int i = 0; i < sn; i++)
            if(sg[cur][i] > 0)
                for(int j = 0; j <= size && j <= rest; j++){
                    String h = str[cur].substring(0, j);
                    String t = dfs(i, rest - j);
                    if(t.equals(fail))
                        continue;
                    String ht = h + t;
                    if(ret == null || ret.compareTo(ht) > 0)
                        ret = ht;
                }
        if(ret == null)
            ret = fail;
        return memo[cur][rest] = ret;
    }

    void run() throws Exception{
        //Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        // only sc.readLine() is available
        String[] nmk = sc.readLine().split(" ");
        n = Integer.parseInt(nmk[0]);
        m = Integer.parseInt(nmk[1]);
        k = Integer.parseInt(nmk[2]);
        c = new char[n];
        String[] cs = sc.readLine().split(" ");
        for(int i = 0; i < n; i++)c[i] = cs[i].charAt(0);
        g = new int[n][n];
        for(int i = 0; i < m; i++){
            String[] ab = sc.readLine().split(" ");
            int a = Integer.parseInt(ab[0]) - 1;
            int b = Integer.parseInt(ab[1]) - 1;
            g[a][b] = 1;
        }
        SCC scc = new SCC(g);
        ss = scc.scc();
        sn = ss.size();
        si = new int[n];
        str = new String[sn];
        for(int i = 0; i < sn; i++){
            ArrayList<Character> t = new ArrayList<Character>();
            for(Integer j : ss.get(i)){
                si[j] = i;
                t.add(c[j]);
            }
            Collections.sort(t);
            String st = "";
            for(Character ccc : t)
                st += ccc;
            str[i] = st;
        }
        sg = new int[sn][sn];
        for(int i = 0; i < sn; i++)
            for(Integer j : ss.get(i))
                for(int k = 0; k < n; k++)
                    if(g[j][k] > 0 && si[j] != si[k])
                        sg[si[j]][si[k]] = 1;
        memo = new String[sn][k+1];
        String ans = null;
        for(int i = 0; i < sn; i++){
            String s = dfs(i, k);
            if(s.equals(fail))
                continue;
            if(ans == null || ans.compareTo(s) > 0)
                ans = s;
        }
        if(ans == null)
            ans = "-1";
        System.out.println(ans);
    }
}

class SCC{
    int n;
    int[][] g;
    int[][] r;
    boolean[] visited;

    SCC(int[][] a){
        g = a;
        n = g.length;
        visited = new boolean[n];
        r = new int[n][n];
        for(int i = 0; i < n;i++)
            for(int j = 0; j < n;j++)
                if(g[i][j] > 0)r[j][i] = g[i][j];
    }
    ArrayList< ArrayList<Integer> > scc(){
        ArrayList<Integer> order = new ArrayList<Integer>();
        Arrays.fill(visited, false);
        for(int i = 0; i < n;i++) dfs(i, order, g);
        Collections.reverse(order);
        ArrayList< ArrayList<Integer> > components =
            new ArrayList< ArrayList<Integer> > ();
        Arrays.fill(visited, false);
        for(int i = 0; i < n;i++){
            if(!visited[order.get(i)]){
                components.add(new ArrayList<Integer>());
                dfs(order.get(i), components.get(components.size()-1),r);
            }
        }
        return components;
    }

    void dfs(int a, ArrayList<Integer> order, int[][] c){
        if(visited[a])return;
        visited[a] = true;
        for(int i = 0; i < n;i++)if(c[a][i] > 0)dfs(i, order, c);
        order.add(a);
    }

}
