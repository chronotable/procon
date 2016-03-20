import java.util.*;
import static java.lang.Math.*;

public class ColorfulRabbits{
    public int getMinimum(int[] rep){
        int ret = 0;
        int[] f = new int[1000001];
        for(int r : rep)f[r]++;
        for(int i = 0; i < f.length; i++)if(f[i] > 0){
                while(f[i] > 0){
                    ret += i + 1;
                    f[i] -= i + 1;
                }
            }
        return ret;
    }
}
