import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(;n>0;n--){
            String s = sc.next();
            String t = sc.next();
            char[] a = new char[s.length()+1];
            char[] b = new char[t.length()+1];
            for(int i = 1; i<a.length; i++)a[i] = s.charAt(i-1);
            for(int i = 1; i < b.length;i++)b[i] = t.charAt(i-1);
            char[] c = new char[t.length()+1];
            for(int i = 1; i < c.length; i++)c[i] = t.charAt(t.length()-i);
            int ans = max(lcs(a,b), lcs(a,c));
            System.out.printf("%s\n", ans == t.length() ? "YES" : "NO");
        }
    }

    int lcs(char[] a, char[] b){
        int[][] dp = new int[a.length][b.length];
        for(int i = 1; i < a.length; i++){
            for(int j = 1; j < b.length; j++){
                if(a[i] == b[j]){
                    dp[i][j] = max(dp[i-1][j-1]+1,
                                   max(dp[i-1][j], dp[i][j-1]));
                }else{
                    dp[i][j] = max(dp[i-1][j-1],
                                   max(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[a.length-1][b.length-1];
    }
}
