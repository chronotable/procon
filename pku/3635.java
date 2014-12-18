import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	int[] price = new int[n];
	int[][] dis = new int[n][n];
	int[][] des = new int[n][n];
	int[] noe = new int[n];
	for(int i = 0; i < n; i++)price[i] = sc.nextInt();
	for(int i = 0; i < m; i++){
	    int s = sc.nextInt();
	    int e = sc.nextInt();
	    int d = sc.nextInt();
	    dis[s][noe[s]] = d;
	    des[s][noe[s]++] = e;
	    dis[e][noe[e]] = d;
	    des[e][noe[e]++] = s;
	}
	final int INF = 1000000000;
	for(int o = sc.nextInt(); o > 0; o--){
	    int cap = sc.nextInt();
	    int start = sc.nextInt();
	    int end = sc.nextInt();
	    int[][] dp = new int[n][cap+1];
	    for(int i = 0; i < n; i++)Arrays.fill(dp[i], INF);
	    dp[start][0] = 0;
	    Queue<E> q = new PriorityQueue<E>();
	    q.offer(new E(start, 0, 0));
	    while(!q.isEmpty()){
		E t = q.poll();
		if(dp[t.pos][t.fuel] != t.cost)continue;
		if(t.pos == end)break;
		if(t.fuel < cap &&
		   t.cost + price[t.pos] < dp[t.pos][t.fuel+1]){
		    dp[t.pos][t.fuel+1] = t.cost + price[t.pos];
		    q.offer(new E(t.pos, t.fuel+1, t.cost + price[t.pos]));
		}
		for(int i = 0; i < noe[t.pos]; i++){
		    if(t.fuel < dis[t.pos][i] ||
		       dp[des[t.pos][i]][t.fuel - dis[t.pos][i]]
		       <= t.cost)continue;
		    dp[des[t.pos][i]][t.fuel - dis[t.pos][i]] = t.cost;
		    q.offer(new E(des[t.pos][i],
				  t.fuel - dis[t.pos][i],
				  t.cost));
		}
	    }
	    int ans = INF;
	    for(int i = 0; i <= cap; i++)
		ans = min(ans, dp[end][i]);
	    if(ans != INF)System.out.println(ans);
	    else System.out.println("impossible");
	}
    }

    class E implements Comparable<E>{
	int pos, fuel, cost;
	E(int a, int b, int c){
	    pos = a;
	    fuel = b;
	    cost = c;
	}
	public int compareTo(E e){
	    return this.cost - e.cost;
	}
    }
}