
import java.util.*;

public class Main{

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int k = sc.nextInt();
	PriorityQueue<Info> q = new PriorityQueue<Info>();
	int[] dp = new int[k+1];
	for(int i = 0; i < k+1;i++)
	    dp[i] = 10000;
	int[] prev = new int[k+1];
	boolean[][] con = new boolean[k+1][k+1];
	for(int i = 0; i < n;i++){
	    con[sc.nextInt()][sc.nextInt()] = true;
	}
	q.offer(new Info(1,1,1));
	while(!q.isEmpty()){
	    Info t = q.poll();
	    if(dp[t.pos] <= t.num)continue;
	    dp[t.pos] = t.num;
	    prev[t.pos] = t.pre;
	    if(t.pos==k)break;
	    for(int i = 1; i <= k;i++){
		if(con[t.pos][i]){
		    q.offer(new Info(t.num+1,i,t.pos));
		}
	    }
	}
	if(dp[k] == 10000){
	    System.out.println(-1);
	}else{
	    System.out.println(dp[k]);
	    int[] ans = new int[dp[k]];
	    int ind = 0;
	    for(int r = k;r != prev[r];r = prev[r])ans[ind++] = r;
	    ans[ind++] = 1;
	    for(int i = ans.length-1;i >= 0;i--)System.out.println(ans[i]);
	}
    }

}

class Info implements Comparable<Info>{

    int num;
    int pos;
    int pre;

    Info(int a, int b, int c){
	num = a;
	pos = b;
	pre = c;
    }

    public int compareTo(Info i){
	return num - i.num;
    }

}
