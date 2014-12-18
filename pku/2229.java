import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < dp.length;i++){
            if(i%2==1)dp[i] = dp[i-1];
            else dp[i] = dp[i-2] + dp[i/2];
            dp[i] %= 1000000000;
        }
        for(;sc.hasNext();){
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
    /*
    //TLE
    int[][] dp = new int[1000001][20];
    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //dp = new int[n+1][20];
        dp[0][0] = dp[1][0] = 1;
        int[] bn = new int[21];
        for(int i = 0; i < 21;i++)bn[i] = (1<<i);
        for(int i = 1; i< 20;i++){
            dp[0][i] += dp[0][i-1];
            dp[1][i] += dp[1][i-1];
        }
        int ind = 0;
        for(int i =2;i <= n;i++){
            if(i == bn[ind+1])ind++;
            for(int j = 0; j <= ind; j++){
                dp[i][j] += dp[i - bn[j]][j];
            }
            for(int j = 1; j < 20;j++){
                dp[i][j] += dp[i][j-1];
                dp[i][j] %= 1000000000;
            }
        }
        System.out.println(dp[n][19]);
    }
    */
}
