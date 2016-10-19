import java.util.*;
import static java.lang.Math.*;

public class ColorfulGarden{
    public String[] rearrange(String[] garden){
        int h = 2;
        int w = garden[0].length();
        int[] f = new int[26];
        for(int i = 0; i < h; i++)for(int j = 0; j < w; j++)f[garden[i].charAt(j) - 'a']++;
        char[][] a = new char[h][w];
        int count = 0;
        for(int p = 0; p < f.length; p++){
            if(f[p] == w && count == 0){
                for(int i = 0; i < w; i++)a[i%2][i] = (char)(p + 'a');
                count += w;
                f[p] = 0;
            }else if(f[p] > w)return new String[0];
        }
        for(int p = 0; p < f.length; p++)for(int q = 0; q < f[p]; q++){
                int y = ((count%2)+(count/w))%2;
                if(w % 2 == 1 && count >= w)y = (y + 1) % 2;
                final int x = count % w;
                final char c = (char)(p + 'a');
                //System.out.println("y=" + y + " x=" + x + " c=" + c);
                a[y][x] = c;
                count++;
            }
        return new String[]{new String(a[0]), new String(a[1])};
    }
}
