import java.util.*;
import static java.lang.Math.*;

public class TheMatrix{
    public int MaxArea(String[] board){
        int h = board.length;
        int w = board[0].length();
        boolean[][] b = new boolean[h][w];
        for(int i = 0; i < h; i++)for(int j = 0; j < w; j++)b[i][j] = board[i].charAt(j) == '1';
        int[][] len = new int[h][w];
        for(int i = 0; i < h; i++)for(int j = 0; j < w; j++){
                int k = j+1;
                for(; k < w; k++)if(b[i][k] == b[i][k-1])break;
                len[i][j] = k-j;
            }
        int ans = 0;
        for(int j = 0; j < w; j++)for(int i = 0; i < h; i++){
                int cur = len[i][j];
                ans = max(ans, cur);
                for(int k = i+1; k < h; k++){
                    if(b[k][j] != b[k-1][j]){
                        cur = min(cur, len[k][j]);
                        ans = max(ans, cur * (k-i+1));
                    }else{
                        break;
                    }
                }
            }
        return ans;
    }
}