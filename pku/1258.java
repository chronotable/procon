import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n;
	for(;sc.hasNext();){
	    n = sc.nextInt();
	    int[][] tbl = new int[n][n];
	    for(int i = 0; i < n;i++)
		for(int j = 0; j < n;j++)
		    tbl[i][j] = sc.nextInt();
	    int ans = 0;
	    for(;;){
		int mn = 100001;
		int ind = 0;
		for(int i = 1;i < n;i++)
		    if(tbl[0][i]<mn){mn=tbl[0][i];ind=i;}
		if(mn==100001)break;
		ans+=mn;
		for(int i = 1; i < n;i++)
		    if(tbl[0][i]!=100001 && tbl[0][i]>tbl[ind][i])
			tbl[0][i] = tbl[ind][i];
		tbl[0][ind] = 100001;
	    }
	    System.out.println(ans);
	}
    }
}