import java.util.*;
import static java.lang.Math.*;

public class MakeSquare{
    public int minChanges(String s){
        int ans = s.length();
        for(int i = 1; i < s.length(); i++){
            char[] a = s.substring(0, i).toCharArray();
            char[] b = s.substring(i).toCharArray();
            EditDistance ed = new EditDistance(a, b);
            ans = min(ans, ed.editDistance());
        }
        return ans;
    }
}


class EditDistance{
    char[] a; // source
    int an;
    char[] b; // destination
    int bn;
    int[][] dp;
    char[][] hist; // 'R': Replace, 'D': Delete, 'I': Insert, ' ': none

    public EditDistance(char[] _a, char[] _b){
        a = _a;
        an = a.length;
        b = _b;
        bn = b.length;
        dp = new int[an+1][bn+1];
        hist = new char[an+1][bn+1];
        for(int i = 0; i <= an; i++){
            for(int j = 0; j <= bn; j++){
                if(i == 0){
                    if(j > 0){
                        dp[i][j] = dp[i][j-1] + 1;
                        hist[i][j] = 'I';
                    }
                }else{
                    if(j == 0){
                        dp[i][j] = dp[i-1][j] + 1;
                        hist[i][j] = 'D';
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j] + 1,
                                            Math.min(dp[i][j-1]+1, dp[i-1][j-1] + (a[i-1] == b[j-1] ? 0 : 1)));
                        hist[i][j] = ' ';
                        if(dp[i][j] == dp[i-1][j]+1)
                            hist[i][j] = 'D';
                        else if(dp[i][j] == dp[i][j-1]+1)
                            hist[i][j] = 'I';
                        else if(dp[i][j] == dp[i-1][j-1]+1)
                            hist[i][j] = 'R';
                    }
                }
            }
        }
    }

    public int editDistance(){
        return dp[an][bn];
    }

}