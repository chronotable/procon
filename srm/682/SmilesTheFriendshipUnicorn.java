import java.util.*;
import static java.lang.Math.*;

public class SmilesTheFriendshipUnicorn{
    public String hasFriendshipChain(int n, int[] a, int[] b){
        HashSet<Integer>[] g = new HashSet[n];
        for(int i = 0; i < n; i++)g[i] = new HashSet<Integer>();
        int m = a.length;
        for(int i = 0; i < m; i++){g[a[i]].add(b[i]); g[b[i]].add(a[i]);}
        for(int i = 0; i < n; i++)for(int s : g[i])for(int t : g[i])if(s != t){
                        for(int u : g[s])if(u != i && u != s && u != t){
                                int size = g[t].size();
                                if(g[t].contains(i))size--;
                                if(g[t].contains(s))size--;
                                if(g[t].contains(u))size--;
                                if(size>0)return "Yay!";
                            }
                    }
        return ":(";
    }
}
