import java.util.*;

public class Main{
  
  static int n;
  static int[] t;
  
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    t = new int[n];
    int ans=0;
    for(int i = 0; i < n;i++)t[i]=sc.nextInt();
    int[][] dp = new int[n+1][n+1];
    for(int i = 0; i < n;i++){
      for(int j = 0; j <= i+1;j++){
        if(j<i+1) dp[i+1][j]=Math.max(dp[i+1][j],dp[i][j]+(i+1)*t[n-1-(i-j)]);
        if(j>0){
          dp[i+1][j]=Math.max(dp[i+1][j],dp[i][j-1]+(i+1)*t[j-1]);
        }
        ans=Math.max(dp[i+1][j],ans);
      }
    }
    /*
    for(int i = 1;i <=n;i++){
      for(int j = 0;j <= n;j++){
        System.out.println("i=" + i + " j=" + j + " v=" + dp[i][j]);
      }
    }
    */
    System.out.println(ans);
  }
}