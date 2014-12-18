
import java.util.*;

public class Main{

    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int n,m;
	outer: for(int o = 1;;o++){
	    n = sc.nextInt();
	    m = sc.nextInt();
	    if(n+m==0)break;
	    String[] bef = new String[m];
	    String[] aft = new String[m];
	    int[] cost = new int[m];
	    for(int i = 0; i < m;i++){
		cost[i] = sc.nextInt();
		bef[i] = sc.next();
		aft[i] = sc.next();
	    }
	    PriorityQueue<Long> q = new PriorityQueue<Long>();
	    int[] dp = new int[1 << n];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    System.out.println("Product " + o);
	    q.offer((1l << n) - 1);
	    while(!q.isEmpty()){
		long v = q.poll();
		int c = (int)(v >> 32);
		int s = (int)v;
		if(dp[s] < c)continue;
		dp[s] = c;
		if(s==0){
		    System.out.printf("Fastest sequence takes %d seconds.\n\n",c);
		    continue outer;
		}
		for(int i = 0; i < m;i++){
		    if(ok(s,bef[i])){
			int news = fix(s,aft[i]);
			long newv = ((long)(c+cost[i]) << 32) + news;
			if(dp[news] >= c+cost[i])q.offer(newv);
		    }
		}
	    }
	    System.out.printf("Bugs cannot be fixed.\n\n");
	}
    }

    static boolean ok(int s, String p){
	for(int i = 0; i < p.length();i++){
	    if(p.charAt(i)== '-' && (s & (1 << i)) > 0) return false;
	    if(p.charAt(i)== '+' && (s & (1 << i)) == 0) return false;
	}
	return true;
    }

    static int fix(int s, String p){
	for(int i = 0; i < p.length();i++){
	    if(p.charAt(i) == '-') s &= ~(1 << i);
	    if(p.charAt(i) == '+') s |= 1 << i;
	}
	return s;
    }

}
