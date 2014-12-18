import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt(), d = sc.nextInt(), k=sc.nextInt();
	int[] t = new int[n];
	int[][] p = new int[n][n];
	for(int i = 0; i < n;i++){
	    t[i] = sc.nextInt();
	    for(int j = 0; j < t[i];j++)
		p[i][j] = sc.nextInt()-1;
	}
	int ans = 0;
	for(int i = 1; i < (1<<d);i++){
	    int c = 0;
	    for(int j = 0; j < d;j++)if(((i>>j) & 1)==1)c++;
	    if(c!=k)continue;
	    boolean[] u = new boolean[d];
	    for(int j = 0; j < d;j++)if(((i>>j) & 1)==1)u[j]=true;
	    int x = 0;
	    for(int j = 0; j < n;j++){
		boolean f = true;
		if(t[j]>k){
		    f=false;
		    break;
		}
		for(int m = 0; m < t[j];m++){
		    if(!u[p[j][m]]){
			f=false;
			break;
		    }
		}
		if(f)x++;
	    }
	    if(x>ans)ans=x;
	}
	System.out.println(ans);
    }
}