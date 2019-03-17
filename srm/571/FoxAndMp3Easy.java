import java.util.*;
import static java.lang.Math.*;

public class FoxAndMp3Easy{
    public String[] playList(int n){
        int m = min(n, 50);
        String[] a = new String[n];
        for(int i = 0; i < n; i++)a[i] = (i+1) + ".mp3";
        Arrays.sort(a);
        String[] ret = new String[m];
        for(int i = 0; i < m; i++)ret[i] = a[i];
        return ret;
    }
}
