
import java.util.*;

public class Main{

    private static final int EPS = 1000000;
    static int[] dp = new int[EPS];

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int u,l;
	for(;sc.hasNext();){
	    l = sc.nextInt();
	    u = sc.nextInt();
	    int i = l>u ? u : l;
	    int j = l<u ? u : l;
	    int ans = -1;
	    for(int k = i;k <= j;k++){
		int v = tra(k);
		if(v > ans)ans=v;
	    }
	    System.out.println(l + " " + u + " " + ans);
	}
    }

    public static int tra(long p){
	if(EPS <= p){
	    if(p % 2 == 1) return 1 + tra(p*3+1);
	    else return 1 + tra(p/2);
	}
	int ip = (int)p;
	if(dp[ip]!=0)return dp[ip];
	if(ip==1)return 1;
	int v;
	if(ip % 2 == 1) v = tra(ip*3+1);
	else v = tra(ip/2);
	v++;
	dp[ip]=v;
	return v;
    }

}

