import java.util.*;
import static java.lang.Math.*;

public class ColoredStrokes{
    public int getLeast(String[] pic){
        int h = pic.length;
        int w = pic[0].length();
        int[][] c = new int[h][w];
        for(int i = 0; i < h; i++)for(int j = 0; j < w; j++){
                char d = pic[i].charAt(j);
                int color = 0;
                if(d == 'R')color = 1;
                else if(d == 'B')color = 2;
                else if(d == 'G')color = 3;
                c[i][j] = color;
            }
        int ans = 0;
        // horizontal red = 1
        for(int i = 0; i < h; i++)for(int j = 0; j < w; j++)if(c[i][j] % 2 == 1){
                    ans++;
                    int k = j;
                    while(k < w && c[i][k] % 2 == 1){c[i][k] -= 1; k++;}
                }
        // vertical blue = 2
        for(int j = 0; j < w; j++)for(int i = 0; i < h; i++)if(c[i][j] == 2){
                    ans++;
                    int k = i;
                    while(k < h && c[k][j] == 2){c[k][j] -= 2; k++;}
                }
        return ans;
    }
}
