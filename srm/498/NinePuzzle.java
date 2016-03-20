import java.util.*;
import static java.lang.Math.*;

public class NinePuzzle{
    public int getMinimumCost(String a, String g){
        int ans = 0;
        for(int i = 0; i < g.length(); i++){
            char c = g.charAt(i);
            int b = a.indexOf(c);
            if(b >= 0){
                a = a.substring(0, b) + a.substring(b+1);
            }else{
                ans++;
            }
        }
        return ans;
    }
}