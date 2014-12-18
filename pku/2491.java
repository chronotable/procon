import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int o = 1; o <= T; o++){
            int s = sc.nextInt();
            int[][] con = new int[s][s];
            Hashtable<String, Integer> n2i = new Hashtable<String, Integer>();
            Hashtable<Integer, String> i2n = new Hashtable<Integer, String>();
            for(int i = 0; i < s-1; i++){
                String p = sc.next();
                int pi = -1, qi = -1;
                if(n2i.containsKey(p)){
                    pi = n2i.get(p);
                }else{
                    pi = n2i.size();
                    n2i.put(p, pi);
                    i2n.put(pi, p);
                }
                String q = sc.next();
                if(n2i.containsKey(q)){
                    qi = n2i.get(q);
                }else{
                    qi = n2i.size();
                    n2i.put(q, qi);
                    i2n.put(qi, q);
                }
                con[pi][qi] = 1;
            }
            ArrayList<Integer> order = new ArrayList<Integer>();
            TopologicalSort.topologicalSort(con, order);
            System.out.println("Scenario #" + o + ":");
            for(int i = 0; i < order.size(); i++)
                System.out.println(i2n.get(order.get(i)));
            System.out.println();
        }
    }
}

class TopologicalSort{
    static boolean visit(int[][] graph, int v,
                         ArrayList<Integer> order, int[] color){
        color[v] = 1;
        for(int i = 0; i < graph[v].length;i++){
            if(graph[v][i] == 0)continue;
            if(color[i] == 2)continue;
            if(color[i] == 1)return false;
            if(!visit(graph, i, order, color))return false;
        }
        order.add(v);
        color[v] = 2;
        return true;
    }

    static boolean topologicalSort(int[][] graph, ArrayList<Integer> order){
        int[] color = new int[graph.length];
        for(int i = 0; i < graph.length;i++){
            if(color[i] == 0 && !visit(graph, i, order, color))
                return false;
        }
        Collections.reverse(order);
        return true;
    }

    /* test  */
    public static void main(String[] args){
        int[][] con = new int[][]{
            {0,1,1,0},
            {0,0,1,0},
            {0,0,0,1},
            {0,0,0,0},
        };
        /*
          //not one
        int[][] con = new int[][]{
            {0,1,1,0},
            {0,0,1,0},
            {0,0,0,1},
            {1,0,0,0},
        };
        */
        ArrayList<Integer> ord = new ArrayList<Integer>();
        if(topologicalSort(con, ord)){
            System.out.println("topological found");
            for(int v : ord)System.out.print(v + " ");
            System.out.println();
        }else{
            System.out.println("can not sort");
        }
    }

}
