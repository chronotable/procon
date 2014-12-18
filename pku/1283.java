import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	long[][] dp = new long[201][201];
	dp[0][0]=1;
	for(int i = 1; i <= 200;i++){
	    for(int j = 1; j <= i;j++){
		dp[i][j]=dp[i-j][j] + dp[i-1][j-1];
	    }
	}
	for(;;){
	    int a = sc.nextInt();
	    int b = sc.nextInt();
	    if(a+b==0)break;
	    System.out.println(dp[a][b]);
	}
    }
}