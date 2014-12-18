import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    int[][][] dp = new int[200][200][15];
    static final int IX = 100;
    static final int IY = 100;

    int tra(int x, int y, int n){
	if(dp[x][y][n] >= 0)return dp[x][y][n];
	if(n==0) return x == IX && y == IY ? 1 : 0;
	int ret = 0;
	ret += tra(x+2, y, n-1);
	ret += tra(x-2, y, n-1);
	ret += tra(x+1, y+1, n-1);
	ret += tra(x+1, y-1, n-1);
	ret += tra(x-1, y+1, n-1);
	ret += tra(x-1, y-1, n-1);
	return dp[x][y][n] = ret;
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	for(int i = 0; i < dp.length; i++)
	    for(int j = 0; j < dp[i].length; j++)Arrays.fill(dp[i][j], -1);
	for(int o = sc.nextInt(); o > 0; o--){
	    int n = sc.nextInt();
	    System.out.println(tra(IX, IY, n));
	}
    }
}
