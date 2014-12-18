import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int n = sc.nextInt();
	    if(n==0)break;
	    int[][] tbl = new int[n][n];
	    for(int i = 0; i < n;i++){
		Arrays.fill(tbl[i],Integer.MAX_VALUE);
		tbl[i][i]=0;
	    }
	    for(int i = 0; i < n-1;i++){
		int from = (int)(sc.next().charAt(0) - 'A');
		int x = sc.nextInt();
		for(int j = 0; j < x;j++){
		    int to = (int)(sc.next().charAt(0)-'A');
		    int cost = sc.nextInt();
		    tbl[from][to]=tbl[to][from]=cost;
		}
	    }
	    int ans = 0;
	    for(int i = 1; i < n;i++){
		int mn=Integer.MAX_VALUE,ind=0;
		for(int j=1;j<n;j++){
		    if(tbl[0][j]<0)continue;
		    if(mn>tbl[0][j]){
			mn=tbl[0][j];
			ind=j;
		    }
		}
		ans+=mn;
		for(int j = 1; j < n;j++)
		    tbl[0][j]=Math.min(tbl[0][j],tbl[ind][j]);
		tbl[0][ind] = -1;
	    }
	    System.out.println(ans);
	}
    }
}