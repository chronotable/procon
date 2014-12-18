import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(;T > 0;T--){
            int w = sc.nextInt();
            int h = sc.nextInt();
            int[][] z = new int[h][w];
            for(int i = 0; i < h; i++)
                for(int j = 0; j < w; j++)
                    z[i][j] = sc.nextInt();
            int[] col_sum = new int[w];
            for(int j = 0; j < w; j++)
                for(int i = 0; i < h; i++)col_sum[j] += z[i][j];
            //for(int j = 0; j < w; j++)
            //    System.out.printf("col %d: sum = %d\n", j, col_sum[j]);
            int ans = Integer.MAX_VALUE;
            for(int i = 0; i < h; i++){
                int[] prev = new int[3];
                // init vertical
                for(int y = 0; y < h; y++)prev[1] += z[y][0] * abs(y-i);
                // init right
                for(int y = 0; y < h; y++)
                    for(int x = 1; x < w; x++)
                        prev[2] += z[y][x] * (abs(y-i) + abs(x));
                ans = min(ans, prev[0] + prev[1] + prev[2]);
                //printStat(prev, i, 0);
                for(int j = 1; j < w; j++){
                    int[] next = new int[3];
                    next[0] = prev[0];
                    for(int x = 0; x < j; x++)next[0] += col_sum[x];
                    next[0] += prev[1];
                    for(int y = 0; y < h; y++)next[1] += z[y][j] * abs(y-i);
                    next[2] = prev[2];
                    for(int x = j; x < w; x++)next[2] -= col_sum[x];
                    next[2] -= next[1];
                    ans = min(ans, next[0] + next[1] + next[2]);
                    prev = next;
                    //printStat(prev, i, j);
                }
            }
            System.out.printf("%d blocks\n", ans);
        }
    }

    void printStat(int[] stat, int row, int col){
        System.out.printf("(%d, %d, %d) at row = %d col = %d\n",
                          stat[0], stat[1], stat[2], row, col);
    }
}
