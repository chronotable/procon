import java.util.*;
import static java.lang.Math.*;

public class BichromePainting{
    public String isThatPossible(String[] board, int k){
        int n = board.length;
        char[][] b = new char[n][];
        for(int i = 0; i < n; i++)b[i] = board[i].toCharArray();
        boolean updated = true;
        while(updated){
            updated = false;
            for(int y = 0; y <= n - k; y++)for(int x = 0; x <= n - k; x++){
                    int wn = 0, bn = 0;
                    for(int i = 0; i < k; i++)for(int j = 0; j < k; j++){
                            if(b[y+i][x+j]=='W')wn++;
                            if(b[y+i][x+j]=='B')bn++;
                        }
                    if((wn > 0 && bn > 0) || (wn + bn == 0))continue;
                    for(int i = 0; i < k; i++)for(int j = 0; j < k; j++)b[y+i][x+j] = '*';
                    updated = true;
                }
        }
        for(int y = 0; y < n; y++)for(int x = 0; x < n; x++)if(b[y][x] != '*')return "Impossible";
        return "Possible";
    }
}
