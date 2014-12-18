import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int[][] init = new int[4][4];
	for(int i = 0; i < 4;i++){
	    String s = sc.next();
	    for(int j = 0; j < s.length();j++){
		if(s.charAt(j)=='b')init[i][j] = 0;
		else init[i][j] = 1;
	    }
	}
	PriorityQueue<Info> q = new PriorityQueue<Info>();
	q.offer(new Info(init,0));
	int[] dp = new int[1 << 16];
	Arrays.fill(dp, Integer.MAX_VALUE);
	int ans = 100000;
	while(!q.isEmpty()){
	    Info temp = q.poll();
	    if(dp[temp.v] <= temp.n)continue;
	    dp[temp.v] = temp.n;
	    if(temp.v == 0 || temp.v == (1 << 16) - 1){
		ans = temp.n;
		break;
	    }
	    for(int i = 0; i < 16;i++){
		int[][] p = new int[4][4];
		for(int j = 0; j < 4;j++){
		    for(int k = 0; k < 4;k++){
			p[j][k] = temp.state[j][k];
		    }
		}
		int r = i / 4;
		int c = i % 4;
		p[r][c] = 1 -p[r][c];
		if(r > 0)p[r-1][c] = 1 - p[r-1][c];
		if(c < 3)p[r][c+1] = 1 - p[r][c+1];
		if(r < 3)p[r+1][c] = 1 - p[r+1][c];
		if(c > 0)p[r][c-1] = 1 - p[r][c-1];
		q.offer(new Info(p, temp.n+1));
	    }
	}
	if(ans!=100000)System.out.println(ans);
	else System.out.println("Impossible");
    }

    static class Info implements Comparable<Info>{
	int[][] state;
	int n, v;
	Info(int[][] a, int b){
	    state = a;
	    n = b;
	    v = 0;
	    for(int i = 0; i < 4;i++){
		for(int j = 0; j < 4;j++){
		    v += (1 << (i*4+j)) * state[i][j];
		}
	    }
	}
	public int compareTo(Info i){
	    return this.n - i.n;
	}
    }
}