import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    int[][] dest = new int[1000][1000];
    int[] dn = new int[1000];

    void run(){
	Scanner sc = new Scanner(System.in);
	int K = sc.nextInt();
	int N = sc.nextInt();
	int M = sc.nextInt();
	int[] cowPos = new int[K];
	for(int i = 0; i < K; i++)cowPos[i] = sc.nextInt()-1;
	for(int i = 0; i < M; i++){
	    int from = sc.nextInt()-1;
	    int to = sc.nextInt()-1;
	    dest[from][dn[from]++] = to;
	}
	boolean[][] reachable = new boolean[K][N];
	for(int i = 0; i < K; i++){
	    tra(reachable[i], cowPos[i]);
	    /*
	    for(int j = 0; j < N; j++)
		System.out.printf("%s", reachable[i][j] ? "Y" : "N");
	    System.out.println();
	    */
	}
	for(int i = 1; i < K; i++){
	    for(int j = 0; j < N; j++)
		reachable[0][j] = reachable[0][j] && reachable[i][j];
	}
	int ans = 0;
	for(int i = 0; i < N; i++)
	    if(reachable[0][i])ans++;
	System.out.println(ans);
    }

    void tra(boolean[] u, int init){
	int[] q = new int[u.length * 2];
	int qn = 0;
	u[init] = true;
	q[qn++] = init;
	for(int cur = 0; cur < qn; cur++){
	    int pos = q[cur];
	    for(int i = 0; i < dn[pos]; i++){
		if(u[dest[pos][i]])continue;
		q[qn++] = dest[pos][i];
		u[dest[pos][i]] = true;
	    }
	}
    }
}