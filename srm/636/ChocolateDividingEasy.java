import java.util.*;
import static java.lang.Math.*;

public class ChocolateDividingEasy{
    int h, w;
    int[][] c;
    int[][] s;
    int sum(int y0, int x0, int y1, int x1){
        //if(y0 > y1)System.out.println("Error y0(" + y0 + ") > y1(" + y1 + ")");
        //if(x0 > x1)System.out.println("Error x0(" + x0 + ") > x1(" + x1 + ")");
        y0++; x0++; y1++; x1++;
        return s[y1][x1] - s[y1][x0-1] - s[y0-1][x1] + s[y0-1][x0-1];
    }
    public int findBest(String[] chocolate){
        h = chocolate.length;
        w = chocolate[0].length();
        c = new int[h][w];
        for(int i = 0; i < h; i++)for(int j = 0; j < w; j++)c[i][j] = chocolate[i].charAt(j) - '0';
        s = new int[h+1][w+1];
        for(int i = 1; i <= h; i++)for(int j = 1; j <= w; j++)
                                       s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + c[i-1][j-1];
        int ans = 0;
        for(int i = 0; i < h; i++)for(int j = i+1; j < h-1; j++)
                                      for(int k = 0; k < w; k++)for(int l = k+1; l < w-1; l++){
                                              int[] t = new int[]{
                                                  sum(0, 0, i, k), sum(i+1, 0, j, k), sum(j+1, 0, h-1, k),
                                                  sum(0, k+1, i, l), sum(i+1, k+1, j, l), sum(j+1, k+1, h-1, l),
                                                  sum(0, l+1, i, w-1), sum(i+1, l+1, j, w-1), sum(j+1, l+1, h-1, w-1)
                                              };
                                              Arrays.sort(t);
                                              //System.out.println(Arrays.toString(t));
                                              ans = max(ans, t[0]);
                                          }
        return ans;
    }
}
