import java.util.*;
import static java.lang.Math.*;

public class LostCharacter{
    public int[] getmins(String[] str){
        int n = str.length;
        String[][] tbl = new String[n][2];
        for(int i = 0; i < n; i++){
            tbl[i][0] = str[i].replace("?", "a");
            tbl[i][1] = str[i].replace("?", "z");
        }
        int[] ret = new int[n];
        for(int i = 0; i < n; i++){
            String[] t = new String[n];
            for(int j = 0; j < n; j++)t[j] = i==j ? tbl[j][0] : tbl[j][1];
            Arrays.sort(t);
            //ret[i] = Arrays.binarySearch(t, tbl[i][0]);
            for(int j = 0; j < n; j++)if(tbl[i][0].equals(t[j])){ret[i] = j; break;}
        }
        return ret;
    }
}
