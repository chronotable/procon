import java.util.*;
import static java.lang.Math.*;

public class MafiaGame{
    public double probabilityToLose(int n, int[] d){
        int[] vote = new int[n];
        for(int a : d)vote[a]++;
        int mx = 0;
        for(int i = 0; i < n; i++)mx = max(mx, vote[i]);
        if(mx == 1)return 0;
        int target = 0;
        for(int i = 0; i < n; i++)if(mx == vote[i])target++;
        double ret = 1.0 / target;
        while(target != 1){
            if(n % target == 0)return 0;
            target = n % target;
        }
        return ret;
    
    }
}