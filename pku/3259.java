import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        for(int o = 0; o < F; o++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int w = sc.nextInt();
            double[][] con = new double[n][n];
            for(int i = 0; i < n; i++)Arrays.fill(con[i], BellmanFordFast.WEIGHT_INF);
            for(int i = 0; i < m; i++){
                int s = sc.nextInt() - 1;
                int e = sc.nextInt() - 1;
                double len = sc.nextDouble();
                con[s][e] = min(con[s][e], len);
                con[e][s] = min(con[e][s], len);
            }
            for(int i = 0; i < w; i++){
                int s = sc.nextInt() - 1;
                int e = sc.nextInt() - 1;
                double len = - sc.nextDouble();
                con[s][e] = min(con[s][e], len);
            }
            int[] num = new int[n];
            int[][] cp = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(con[i][j] != BellmanFordFast.WEIGHT_INF){
                        cp[i][num[i]++] = j;
                    }
                }
            }
            BellmanFordFast bff = new BellmanFordFast(num, cp, con);
            System.out.printf("%s\n", bff.shortest(0) ? "NO": "YES");
        }
    }
}

class BellmanFordFast{
    int[] num;
    int[][] counterPart;
    double[][] g;
    static final double WEIGHT_INF = 1e30;

    BellmanFordFast(int[] n, int[][] cp, double[][] d){
        num = n;
        counterPart = cp;
        g = d;
    }

    public boolean shortest(int start){
        int n = g.length;
        double[] costs = new double[n];
        Arrays.fill(costs, WEIGHT_INF);
        int[] trace = new int[n];
        Arrays.fill(trace, -2);
        costs[start] = 0;
        trace[start] = -1; //terminal
        for(int k = 0; k < n; k++){
            for(int a = 0; a < n; a++){
                if(costs[a] != WEIGHT_INF){
                    for(int b = 0;b < num[a];b++){
                        double w = costs[a] + g[a][counterPart[a][b]];
                        if(w < costs[counterPart[a][b]]){
                            costs[counterPart[a][b]] = w;
                            trace[counterPart[a][b]] = a;
                        }
                    }
                }
            }
        }
        //check negative cycle
        for(int a = 0;a < n;a++){
            for(int b = 0; b < num[a];b++){
                if(costs[a] + g[a][counterPart[a][b]] <
                   costs[counterPart[a][b]])
                    return false;
            }
        }
        return true;
    }
}
