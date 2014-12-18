import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int o = sc.nextInt();
        for(;o>0;o--){
            int n = sc.nextInt();
            int m = sc.nextInt();
            Edge[] ed = new Edge[m];
            for(int i = 0; i < m; i++)
                ed[i] = new Edge(sc.nextInt()-1,sc.nextInt()-1,sc.nextInt());
            ArrayList<Integer> as = new ArrayList<Integer>();
            int opt = mst(n, ed, -1, as);
            boolean f = false;
            if(as.size() != n-1)f = true;
            for(int i = 0; i < as.size(); i++){
                ArrayList<Integer> al = new ArrayList<Integer>();
                int sum = mst(n, ed, as.get(i), al);
                if(al.size() == n-1 && sum == opt){
                    f = true;
                    break;
                }
            }
            if(f)System.out.println("Not Unique!");
            else System.out.println(opt);
        }
    }

    int mst(int n, Edge[] ed, int ban, ArrayList<Integer> ar){
        int ret = 0;
        int[] anc = new int[n];
        for(int i = 0; i < n; i++)anc[i] = i;
        for(int i = 0; i < ed.length; i++){
            if(i == ban)continue;
            int a = ed[i].src;
            int b = ed[i].dst;
            if(root(anc, a) == root(anc, b))continue;
            ret += ed[i].wgt;
            ar.add(i);
            union(anc, a, b);
        }
        return ret;
    }

    int root(int[] anc, int a){
        if(anc[a] == a)return a;
        anc[a] = root(anc, anc[a]);
        return anc[a];
    }

    void union(int[] anc, int a, int b){
        int ar = root(anc, a);
        int br = root(anc, b);
        anc[br] = ar;
    }

    class Edge implements Comparable<Edge>{
        int src,dst,wgt;
        Edge(int a, int b, int c){
            src = a;
            dst = b;
            wgt = c;
        }
        public int compareTo(Edge e){
            return this.wgt - e.wgt;
        }
    }
}
