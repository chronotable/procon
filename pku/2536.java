import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	for(;sc.hasNext();){
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    int s = sc.nextInt();
	    int v = sc.nextInt();
	    int t = n+m;
	    double sv = 1.0*s*v;
	    double[] gx = new double[n];
	    double[] gy = new double[n];
	    double[] hx = new double[m];
	    double[] hy = new double[m];
	    for(int i = 0; i < n; i++){
		gx[i] = sc.nextDouble();
		gy[i] = sc.nextDouble();
	    }
	    for(int i = 0; i < m; i++){
		hx[i] = sc.nextDouble();
		hy[i] = sc.nextDouble();
	    }
	    boolean[][] con = new boolean[t][t];
	    for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
		    if(hypot(gx[i] - hx[j], gy[i] - hy[j]) <= sv){
			con[i][j+n] = con[j+n][i] = true;
		    }
		}
	    }
	    BipartiteMatchingSimple bms = new BipartiteMatchingSimple(con);
	    System.out.println(n - bms.maxMatching());
	}
    }
}


class BipartiteMatchingSimple{

    int n;
    boolean[][] con;
    int[] dest;
    boolean[] visit;

    public BipartiteMatchingSimple(boolean[][] connection){
        n = connection.length;
        con = connection;
        //dest = new int[n];
        //Arrays.fill(dest, -1);
        //visit = new boolean[n];
    }

    /* ans = ans / 2!!!! */
    int maxMatching(){
        dest = new int[n];
        Arrays.fill(dest, -1);
        visit = new boolean[n];
        int ret = 0;
        for(int i = 0; i < n; i++){
            visit = new boolean[n];
            if(dfs(i))ret++;
        }
        return ret / 2;
    }

    boolean dfs(int t){
        for(int i = 0; i < n; i++){
            if(!visit[i] && con[t][i]){
                visit[i] = true;
                if(dest[i] < 0 || dfs(dest[i])){
                    //こっちだけで良い
                    dest[i] = t;
                    //これは必要ない
                    //dest[t] = i;
                    return true;
                }
            }
        }
        return false;
    }
}
