import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        for(int o = 1;;o++){
            Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
            ArrayList<Edge> e = new ArrayList<Edge>();
            int n = 0;
            for(;;){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(a < 0 && b < 0)return;
                if(a == 0 && b == 0)break;
                if(!ht.containsKey(a))ht.put(a, n++);
                if(!ht.containsKey(b))ht.put(b, n++);
                e.add(new Edge(ht.get(a), ht.get(b)));
            }
            if(e.size() < 1){
                System.out.printf("Case %d is a tree.\n", o);
                continue;
            }
            boolean[] directed = new boolean[n];
            ArrayList<Integer>[] next = new ArrayList[n];
            for(int i = 0; i < n;i++)next[i] = new ArrayList<Integer>();
            for(int i = 0; i < e.size();i++){
                Edge te = e.get(i);
                /*
                if(!next[te.src].contains(te.dst))
                    next[te.src].add(te.dst);
                */
                next[te.src].add(te.dst);
                directed[te.dst] = true;
            }
            int root = -1;
            loop:
            for(int i = 0; i < n;i++){
                if(!directed[i]){
                    if(root < 0)root = i;
                    else {
                        root = -1;
                        break loop;
                    }
                }
            }
            if(root == -1){
                System.out.printf("Case %d is not a tree.\n", o);
                continue;
            }
            LinkedList<Integer> q = new LinkedList<Integer>();
            q.offer(root);
            boolean[] visited = new boolean[n];
            boolean f = true;
            while(!q.isEmpty()){
                int v = q.poll();
                if(visited[v]){
                    f = false;
                    break;
                }
                visited[v] = true;
                for(int i = 0; i < next[v].size(); i++){
                    q.offer(next[v].get(i));
                }
            }
            for(int i = 0; i < n; i++)if(!visited[i])f=false;
            if(f) System.out.printf("Case %d is a tree.\n", o);
            else System.out.printf("Case %d is not a tree.\n", o);
        }
    }
    class Edge{
        int src,dst;
        Edge(int a, int b){
            src = a;
            dst = b;
        }
    }
}
