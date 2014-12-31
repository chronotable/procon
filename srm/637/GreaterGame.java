import java.util.*;
import static java.lang.Math.*;

public class GreaterGame{
    int n;
    public double calc(int[] hand, int[] sothe){
        n = hand.length;
        double ans = 0;
        Arrays.sort(hand); Arrays.sort(sothe);
        boolean[] cand = new boolean[n*2+1];
        Arrays.fill(cand, true);
        cand[0] = false;
        for(int i = 0; i < n; i++){
            cand[hand[i]] = false;
            if(sothe[i] > 0)cand[sothe[i]] = false;
        }
        boolean[] used = new boolean[n];
        int unk = 0;
        for(int i = n-1; i >= 0; i--){
            if(sothe[i] < 0){
                unk++;
                continue;
            }
            int index = -1;
            for(int j = 0; j < n; j++)if(!used[j] && hand[j] > sothe[i]){
                    if(index < 0)index = j;
                    else if(hand[index] > hand[j])index = j;
                }
            if(index < 0){
                // find the smallest
                for(int j = 0; j < n; j++)if(!used[j]){
                        used[j] = true;
                        break;
                    }
            }else{
                ans = ans + 1;
                used[index] = true;
            }
        }
        if(unk > 0){
            for(int i = 0; i < n; i++)if(!used[i]){
                    int win = 0;
                    for(int j = 1; j < cand.length; j++)if(cand[j] && hand[i] > j)win++;
                    ans += 1.0 * win / unk;
                }
        }
        return ans;
    }
}
