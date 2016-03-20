import java.util.*;
import static java.lang.Math.*;

public class FoxSequence{
    public String isValid(int[] s){
        int n = s.length;
        if(n < 5)return "NO";
        int dif = s[1] - s[0];
        if(dif <= 0)return "NO";
        int up = 1;
        int down = 0;
        for(int i = 2; i < n; i++){
            int d = s[i] - s[i-1];
            if(d == 0){
                if(dif > 0 || down >= 2)return "NO";
                while(i < n && s[i] == s[i-1])i++;
                if(i == n)return "NO";
                dif = s[i] - s[i-1];
                up++;
            }else{
                if(dif * d > 0){
                    if(dif != d)return "NO";
                }else{
                    if(dif > 0)down++;
                    else up++;
                    dif = d;
                }
            }
        }
        return up == 2 && down == 2 ? "YES" : "NO";
    }
}
