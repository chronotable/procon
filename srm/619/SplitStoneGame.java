import java.util.*;
import static java.lang.Math.*;

public class SplitStoneGame{
    int n;
    int[][] memo;
    boolean win(int multi, int solo){
        if(multi < 1 || multi+solo-1 < 2)return false;
        if(memo[multi][solo] != 0)return memo[multi][solo] > 0;
        boolean ret = false;
        if(multi-1 >= 2)ret |= !win(multi-1, solo);
        if(multi-1 >= 1 && solo >= 1) ret |= !win(multi, solo-1);
        if(solo >= 2)ret |= !win(multi+1, solo-2);
        memo[multi][solo] = ret?1:-1;
        return ret;
    }
    public String winOrLose(int[] num){
        n = num.length;
        memo = new int[n+1][n+1];
        int multi = 0, solo = 0;
        for(int n : num){
            if(n > 1)multi++;
            else solo++;
        }
        return win(multi, solo)?"WIN":"LOSE";
    }
}