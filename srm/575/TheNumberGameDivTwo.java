import java.util.*;
import static java.lang.Math.*;

public class TheNumberGameDivTwo{
    private int[][] memo = new int[2][1024];
    private boolean win(int turn, int n){
        if(memo[turn][n] != 0)return memo[turn][n] > 0;
        boolean w = false;
        for(int i = 2; i < n; i++)if(n % i == 0)w |= !win(1-turn, n - i);
        memo[turn][n] = w ? 1 : -1;
        return w;
    }
    public String find(int n){
        return win(0, n) ? "John" : "Brus";
    }
}
