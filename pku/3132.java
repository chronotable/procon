import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	final int N = 1120;
	final int K = 14;
	int[][] tbl = new int[K+1][N+1];
	boolean[] u = new boolean[N+1];
	for(int i = 2;i <= N;i++){
	    if(!u[i]){
		for(int j = i*2; j<= N;j += i)u[j] = true;
	    }
	}
	tbl[0][0]=1;
	for(int i = 2;i <= N;i++){
	    if(!u[i]){
		for(int j=K; j > 0;j--)
		    for(int k = i; k <= N;k++)
			tbl[j][k] += tbl[j-1][k-i];
	    }
	}
	for(;;){
	    int a = sc.nextInt();
	    int b = sc.nextInt();
	    if(a==0 && b==0)break;
	    System.out.println(tbl[b][a]);
	}
    }
}