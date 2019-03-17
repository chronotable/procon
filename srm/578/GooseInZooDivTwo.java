import java.util.*;
import static java.lang.Math.*;

public class GooseInZooDivTwo{
    public int count(String[] field, int dist){
        final int h = field.length;
        final int w = field[0].length();
        char[][] f = new char[h][];
        for(int i = 0; i < h; i++)f[i] = field[i].toCharArray();
        int num_components = 0;
        boolean[][] u = new boolean[h][w];
        for(int i = 0; i < h; i++)for(int j = 0; j < w; j++)if(f[i][j] == 'v' && !u[i][j]){
                    num_components++;
                    u[i][j] = true;
                    Queue<Integer> q = new LinkedList<Integer>();
                    q.offer(i*w+j);
                    while(!q.isEmpty()){
                        int v = q.poll();
                        int y = v / w;
                        int x = v % w;
                        for(int a = 0; a < h; a++)for(int b = 0; b < w; b++)if(f[a][b] == 'v' && !u[a][b] && abs(a-y)+abs(b-x) <= dist){
                                    u[a][b] = true;
                                    q.offer(a*w+b);
                                }
                    }
                }
        if(num_components == 0)return 0;
        int ret = 1;
        for(int i = 0; i < num_components; i++){ret <<= 1; ret %= 1000000007;}
        ret--;
        if(ret < 0)ret = 1000000006;
        return ret;
    }
}
