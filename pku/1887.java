import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(int o = 1;;o++){
	    int a = sc.nextInt();
	    if(a==-1)break;
	    ArrayList<Integer> ar = new ArrayList<Integer>();
	    ar.add(a);
	    for(;;){
		int v = sc.nextInt();
		if(v==-1)break;
		ar.add(v);
	    }
	    int[] dp = new int[ar.size()];
	    int ans = 0;
	    for(int i = 0; i < dp.length;i++){
		int mx = 0;
		int v = ar.get(i);
		for(int j = 0; j < i;j++){
		    if(v <= ar.get(j) && mx < dp[j])mx=dp[j];
		}
		dp[i] = mx+1;
		if(ans < dp[i])ans = dp[i];
	    }
	    System.out.println("Test #" + o + ":");
	    System.out.println("  maximum possible interceptions: " + ans);
	    System.out.println();
	    ar = null;
	}
    }
}