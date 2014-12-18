import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    int n;
    int[][] a;
    int ans;

    void run(){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    n = sc.nextInt();
	    if(n < 0)break;
	    a = new int[n][n];
	    for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
		    a[i][j] = sc.nextInt();
	    int[] si = new int[n];
	    si[0] = 0;
	    ans = Integer.MAX_VALUE;
	    tra(si, 1);
	    System.out.println(ans);
	}
    }

    void tra(int[] s, int cur){
	if(cur == n){
	    val(s);
	    return;
	}
	for(int i = 0; i < n; i++){
	    s[cur] = i;
	    tra(s, cur+1);
	}
    }

    void val(int[] s){
	int[][] mat = new int[n][n];
	for(int i = 0; i < n; i++){
	    for(int j = 0; j < n; j++)
		mat[i][(s[i] + j) % n] = a[i][j];
	}
	int mx = 0;
	for(int i = 0; i < n; i++){
	    int sum = 0;
	    for(int j = 0; j < n; j++)
		sum += mat[j][i];
	    mx = max(mx, sum);
	}
	ans = min(ans, mx);
    }
}