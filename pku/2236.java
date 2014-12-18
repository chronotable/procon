import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    int root(int[] par, int a){
        if(par[a] == a)return a;
        par[a] = root(par, par[a]);
        return par[a];
    }

    void union(int[] par, int a, int b){
        par[b] = par[par[a]];
    }

    void run(){
        final double EPS = 1e-9;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double d = sc.nextInt() * 1.0;
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i = 0; i < n; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        boolean[] repair = new boolean[n];
        double[][] dis = new double[n][n];
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                dis[i][j] = dis[j][i] = hypot(x[i] - x[j], y[i] - y[j]);
            }
        }
        int[] par = new int[n];
        for(int i = 0; i < n; i++)par[i] = i;
        for(;sc.hasNext();){
            String op = sc.next();
            if(op.equals("O")){
                int obj = sc.nextInt() - 1;
                if(!repair[obj]){
                    repair[obj] = true;
                    for(int i = 0; i < n; i++){
                        if(i == obj || !repair[i] || dis[obj][i] > d)
                            continue;
                        union(par, root(par, obj), root(par, i));
                    }
                }
            }else if(op.equals("S")){
                int p = sc.nextInt() - 1;
                int q = sc.nextInt() - 1;
                if(!repair[p] || !repair[q] || root(par, p) != root(par, q))
                    System.out.println("FAIL");
                else
                    System.out.println("SUCCESS");
            }
        }
    }
}
