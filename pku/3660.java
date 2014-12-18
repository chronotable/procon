import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	boolean[][] con = new boolean[n][n];
	for(int i = 0; i < m;i++){
	    int a = sc.nextInt()-1;
	    int b = sc.nextInt()-1;
	    if(a!=b)con[a][b] = true;
	}
	for(int k = 0; k < n;k++)
	    for(int i = 0; i < n;i++)
		for(int j = 0; j < n;j++)
		    if(i!=j)con[i][j] = con[i][j] || (con[i][k] && con[k][j]);
	boolean[] u = new boolean[n];
	int ans = 0;
	for(int i = 0; i < n;i++){
	    int sum = 0;
	    for(int j = 0; j < n;j++){
		if(i==j)continue;
		if(con[i][j] || con[j][i])sum++;
	    }
	    if(sum==n-1)ans++;
	}
	System.out.println(ans);
    }
}
