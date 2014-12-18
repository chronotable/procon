import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int h = sc.nextInt();
            int w = sc.nextInt();
            if(h+w==0)break;
            ArrayList<Integer> mp = new ArrayList<Integer>();
            ArrayList<Integer> hp = new ArrayList<Integer>();
            for(int i = 0; i < h; i++){
                String s = sc.next();
                for(int j = 0; j < w; j++){
                    char c = s.charAt(j);
                    if(c == 'm')mp.add(i * 1000 + j);
                    else if(c == 'H')hp.add(i * 1000 + j);
                }
            }
            int n = mp.size();
            double[][] cap = new double[2*n + 2][2*n + 2];
            double[][] cst = new double[2*n+2][2*n+2];
            //init
            for(int i = 0; i < n; i++){
                cap[0][i+1] = 1;
                //cst[0][i+1] = 1;
                //cst[i+1][0] = -1;
                for(int j = 0; j < n; j++){
                    cap[i+1][n+1+j] = 1;
                    //cst[i+1][n+1+j] = 1;
                    //cst[n+1+j][i+1] = -1;
                }
                cap[n+1+i][2*n+1] = 1;
                //cst[n+1+i][2*n+1] = 1;
                //cst[2*n+1][n+1+i] = -1;
            }
            for(int i = 0; i < mp.size();i++){
                int mv = mp.get(i);
                int my = mv / 1000;
                int mx = mv % 1000;
                for(int j = 0; j < hp.size(); j++){
                    int hv = hp.get(j);
                    int hy = hv / 1000;
                    int hx = hv % 1000;
                    double dis = abs(mx - hx) + abs(my - hy);
                    cst[i+1][n+1+j] = dis;
                    cst[n+1+j][i+1] = -dis;
                }
            }

            /*
            System.out.println("capacity");
            for(int i = 0; i < cap.length; i++){
                for(int j = 0; j < cap[i].length; j++)
                    System.out.print(cap[i][j] + " ");
                System.out.println();
            }

            System.out.println("cost");
            for(int i = 0; i < cst.length; i++){
                for(int j = 0; j < cst[i].length; j++)
                    System.out.print(cst[i][j] + " ");
                System.out.println();
            }
            */

            PrimalDual pd = new PrimalDual(cap, cst);
            System.out.println((int)pd.minCostFlow(0,2*n+1));
        }
    }
}

class PrimalDual{
    double[][] cap;
    double[][] cost;
    private static final double WEIGHT_INFTY = 1e100;
    private static final double FLOW_INFTY = 1e50;
    private static final double EPS = 1e-9;
    /*
     *  CAUTION!!
     * cost matrix must be antisymmetric
     * cap matrix must be non negative
     * cap matrix's positive edges have non negative cost
     */
    PrimalDual(double[][] capacity, double[][] cst){
        cap = capacity;
        cost = cst;
    }
    /*
    #define residue(i,j) (cap[i][j] - flow[i][j])
    #define rcost(i,j) (cost[i][j] + pot[i] - pot[j])
    */
    double minCostFlow(int s, int t){
        int n = cap.length;
        double[][] flow = new double[n][n];
        double[] pot = new double[n];
        double res = 0;
        for(;;){
            double[] dists = new double[n+1];
            Arrays.fill(dists, WEIGHT_INFTY);
            boolean[] visited = new boolean[n];
            int[] trace = new int[n];
            Arrays.fill(trace, -1);
            dists[s] = 0;
            for(;;){
                int cur = n;
                for(int i = 0; i < n; i++)
                    if(!visited[i] && dists[i] < dists[cur])cur = i;
                if(cur == n)break;
                visited[cur] = true;
                for(int next = 0; next < n;next++){
                    //if(residue(cur, next) > EPS){
                    if(cap[cur][next] - flow[cur][next] > EPS){
                        if(dists[next] > dists[cur] +
                           (cost[cur][next] + pot[cur] - pot[next]) &&
                           !visited[next]){
                            dists[next] = dists[cur] +
                                (cost[cur][next] + pot[cur] - pot[next]);
                            trace[next] = cur;
                        }
                    }
                }
            }
            if(!visited[t])break;
            double f = FLOW_INFTY;
            for(int c = t; c != s; c = trace[c])
                f = min(f, cap[trace[c]][c] - flow[trace[c]][c]);
            for(int c = t; c != s; c = trace[c]){
                flow[trace[c]][c] += f;
                flow[c][trace[c]] -= f;
                res += cost[trace[c]][c] * f;
            }
            for(int i = 0; i < n;i++)pot[i] += dists[i];
        }
        /*
        System.out.println("flow map");
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n;j++)System.out.print(flow[i][j] + " ");
            System.out.println();
        }
        */
        return res;
    }
    /* test run */
    public void main(String[] args){
        double[][] cp = new double[][]
        {
            {0,20,30,0,0,0},
            {0,0,0,20,20,0},
            {0,0,0,30,30,0},
            {0,0,0,0,0,20},
            {0,0,0,0,0,30},
            {0,0,0,0,0,0}
        };
        double[][] cst = new double[][]
        {
            {0,1,1,0,0,0},
            {-1,0,0,1,2,0},
            {-1,0,0,2,1,0},
            {0,-1,-2,0,0,1},
            {0,-2,-1,0,0,1},
            {0,0,0,-1,-1,0}
        };
        /*
        double[][] cp = new double[][]
            {
                {0,20,30,0,0,0},
                {0,0,0,20,20,0},
                {0,0,0,30,30,0},
                {0,0,0,0,0,20},
                {0,0,0,0,0,30},
                {0,0,0,0,0,0}
            };
        double[][] cst = new double[][]
            {
                {0,1,1,0,0,0},
                {-1,0,0,1,2,0},
                {-1,0,0,2,5,0},
                {0,-1,-2,0,0,1},
                {0,-2,-5,0,0,1},
                {0,0,0,-1,-1,0}
            };
        */
        PrimalDual pd = new PrimalDual(cp, cst);
        System.out.println(pd.minCostFlow(0,5));
    }
}