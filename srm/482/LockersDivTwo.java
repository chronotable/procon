import java.util.*;
import static java.lang.Math.*;

public class LockersDivTwo{
    public int lastOpened(int n){
        if(n == 1)return 1;
        int[][] a = new int[2][n];
        int m = n / 2;
        for(int i = 0; i < m; i++)a[0][i] = (i*2)+1;
        int cur = 0;
        int turn = 3;
        while(m > 1){
            int next = 1 - cur;
            int nm = 0;
            for(int i = 0; i < m; i++)
                if(i % turn > 0)
                    a[next][nm++] = a[cur][i];
            cur = next;
            turn++;
            m = nm;
        }
        return a[cur][0] + 1;
    }
}
