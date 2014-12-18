import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    int n,m;
    int[][] heavy;
    int[] hn;
    int[][] light;
    int[] ln;

    int calch(int cur, boolean[] u){
	if(u[cur])return 0;
	u[cur] = true;
	int ret = 1;
	for(int i = 0; i < hn[cur]; i++){
	    if(u[heavy[cur][i]])continue;
	    ret += calch(heavy[cur][i], u);
	}
	return ret;
    }

    int calcl(int cur, boolean[] u){
	if(u[cur])return 0;
	u[cur] = true;
	int ret = 1;
	for(int i = 0; i < ln[cur]; i++){
	    if(u[light[cur][i]])continue;
	    ret += calcl(light[cur][i], u);
	}
	return ret;
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	int o = sc.nextInt();
	for(; o > 0; o--){
	    n = sc.nextInt();
	    m = sc.nextInt();
	    heavy = new int[n][n];
	    hn = new int[n];
	    light = new int[n][n];
	    ln = new int[n];
	    for(int i = 0; i < m; i++){
		int h = sc.nextInt()-1;
		int l = sc.nextInt()-1;
		light[h][ln[h]++] = l;
		heavy[l][hn[l]++] = h;
	    }
	    int thr = (n-1) / 2;
	    int ans = 0;
	    for(int i = 0; i < n; i++){
		boolean[] visit = new boolean[n];
		int toth = calch(i, visit)-1;
		if(toth > thr){
		    ans++;
		    continue;
		}
		visit = new boolean[n];
		int totl = calcl(i, visit)-1;
		if(totl > thr)ans++;
	    }
	    System.out.println(ans);
	}
    }
}
