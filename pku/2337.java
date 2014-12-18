import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int o = sc.nextInt();
        for(;o > 0; o--){
            ArrayList< ArrayList<Edge> > graph =
                new ArrayList< ArrayList<Edge> >();
            for(int i =0; i < 26; i++)graph.add(new ArrayList<Edge>());
            int n = sc.nextInt();
            for(int i = 0; i < n; i++){
                String w = sc.next();
                int s = w.charAt(0) - 'a';
                int e = w.charAt(w.length()-1) - 'a';
                graph.get(s).add(new Edge(s, e, w));
            }
            for(int i =0; i < 26; i++)
                Collections.sort(graph.get(i));
            EulerianPath ep = new EulerianPath(graph);
            ArrayList<Integer> path = new ArrayList<Integer>();
            for(int i = 0; i < 26; i++){
                if(ep.eulerPath(i, path)){
                    break;
                }
                path = new ArrayList<Integer>();
            }
            if(path.size() == 0){
                System.out.println("***");
            }else{
                String ans = "";
                for(int i = 0; i < path.size() - 1; i++){
                    int s = path.get(i);
                    int e = path.get(i+1);
                    ArrayList<Edge> tbl = graph.get(s);
                    for(int j = 0; j < tbl.size(); j++){
                        Edge ed = tbl.get(j);
                        if(ed.dst == e){
                            ans = ans + ed.word + ".";
                            tbl.remove(ed);
                            break;
                        }
                    }
                }
                ans = ans.substring(0, ans.length()-1);
                System.out.println(ans);
            }
        }
    }
}


class EulerianPath{
    private ArrayList< ArrayList<Edge> > graph;
    private int[] counter;
    EulerianPath(ArrayList< ArrayList<Edge> > ar){
        graph = ar;
    }
    void visit(int a, ArrayList<Integer> path){
        ArrayList<Edge> tbl = graph.get(a);
        while(counter[a] < tbl.size()){
            int b = tbl.get(counter[a]).dst;
            counter[a]++;
            visit(b, path);
        }
        path.add(a);
    }
    boolean eulerPath(int s, ArrayList<Integer> path){
        int n = graph.size();
        int m = 0;
        counter = new int[n];
        int[] deg = new int[n];
        for(int i = 0; i < n;i++){
            ArrayList<Edge> tbl = graph.get(i);
            m += tbl.size();
            for(int j = 0; j < tbl.size(); j++){
                deg[tbl.get(j).dst]--; //in-deg
            }
            deg[i]+=tbl.size(); //out-deg
        }
        int zs = 0;
        for(int i = 0; i < n;i++)if(deg[i] == 0)zs++;
        int k = n - zs;
        if(k == 0 || (k == 2 && deg[s] == 1)){
            //ArrayList<Integer> path = new ArrayList<Integer>();
            Arrays.fill(counter, 0);
            visit(s, path);
            Collections.reverse(path);
            return path.size() == m+1;
        }
        return false;
    }
}
class Edge implements Comparable<Edge>{
    int src, dst;
    String word;
    Edge(int a, int b, String c){
        src = a;
        dst = b;
        word = c;
    }

    public int compareTo(Edge e){
        return this.word.compareTo(e.word);
    }
}
