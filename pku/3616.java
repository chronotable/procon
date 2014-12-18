
import java.util.*;

public class Main{

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	int r = sc.nextInt();
	Info[] ar = new Info[m];
	for(int i = 0; i < m;i++)
	    ar[i] = new Info(sc.nextInt(),sc.nextInt(),sc.nextInt());
	int[] dp = new int[m];
	Arrays.sort(ar);
	int ans = -1;
	for(int i = 0; i < m;i++){
	    int mx = 0;
	    for(int j = 0; j < i; j++){
		if(ar[j].e <= ar[i].s - r){
		    if(dp[j] > mx) mx = dp[j];
		}
	    }
	    dp[i] = mx + ar[i].p;
	    if(ans < dp[i])ans = dp[i];
	}
	System.out.println(ans);
    }

    static class Info implements Comparable<Info>{
	int s,e,p;
	Info(int a, int b, int c){
	    s=a;
	    e=b;
	    p=c;
	}
	public int compareTo(Info i){
	    if(this.s == i.s)return this.e - i.e;
	    return this.s - i.s;
	}
    }

}
