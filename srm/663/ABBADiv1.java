import java.util.*;
import static java.lang.Math.*;

public class ABBADiv1{
    boolean can(String initial, String target, boolean right, int pos){
        char[] t = target.toCharArray();
        int lp = pos - 1;
        int rp = pos + initial.length();
        while(true){
            if(right){
                if(rp >= t.length)break;
                if(t[rp] == 'B')right = !right;
                rp++;
            }else{
                if(lp < 0)break;
                if(t[lp] == 'B')right = !right;
                lp--;
            }
        }
        return right && lp < 0 && rp >= t.length;
    }
    boolean possible(String initial, String target, boolean right){
        int cur = target.indexOf(initial);
        while(cur >= 0){
            if(can(initial, target, right, cur))return true;
            cur = target.indexOf(initial, cur+1);
        }
        return false;
    }
    public String canObtain(String initial, String target){
        return possible(initial, target, true) || possible(new StringBuilder(initial).reverse().toString(), target, false) ? "Possible" : "Impossible";
    }
}
