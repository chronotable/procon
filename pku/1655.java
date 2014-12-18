import java.util.*;
import static java.lang.Math.*;

public class Main{
    static ArrayList<Integer>[] tbl;
    static int[] balance;
    static int[] children;
    static int n;
    private static void dfs(int cur, int par){
        balance[cur] = 0;
        children[cur] = 1;
        for(int i = 0; i < tbl[cur].size();i++){
            int a = tbl[cur].get(i);
            if(a==par)continue;
            dfs(a, cur);
            children[cur] += children[a];
            balance[cur] = max(balance[cur], children[a]);
        }
        balance[cur] = max(balance[cur], n - children[cur]);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(;t>0;t--){
            n = sc.nextInt();
            tbl = new ArrayList[n];
            balance = new int[n];
            children = new int[n];
            for(int i = 0; i < n;i++)tbl[i] = new ArrayList<Integer>();
            for(int i = 0; i < n-1;i++){
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                tbl[a].add(b);
                tbl[b].add(a);
            }
            dfs(0,-1);
            int mn = 10000000;
            int ind = -1;
            for(int i = 0; i < n;i++){
                if(balance[i] < mn){
                    mn = balance[i];
                    ind = i+1;
                }
            }
            System.out.println(ind + " " + mn);
        }
    }
}