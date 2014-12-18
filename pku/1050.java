import java.util.*;

public class Main{

    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[][] a = new int[n+1][n+1];
	for(int i = 1;i <= n;i++)
	    for(int j = 1;j <= n;j++)
		a[i][j] = sc.nextInt();
	int[][] b = new int[n+1][n+1];
	for(int i = 1;i <= n;i++)
	    for(int j = 1;j <= n;j++)
		b[i][j] = b[i][j-1] + b[i-1][j] + a[i][j] - b[i-1][j-1];
	int ans = -1;
	for(int i = 1;i <= n;i++)
	    for(int j = 1;j <= n;j++)
		for(int k = i;k <= n;k++)
		    for(int l = j;l <= n;l++)
			ans = Math.max(ans, b[i-1][j-1] + b[k][l] - b[k][j-1] - b[i-1][l]);
	System.out.println(ans);
    }

}