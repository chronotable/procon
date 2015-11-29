import java.util.*;
import static java.lang.Math.*;

public class Decipherability{
    int n;
    public String check(String s, int K){
        n = s.length();
        if(n == K)return "Certain";
        for(int i = 0; i < n; i++)for(int j = i + 1; j < n; j++)if(s.charAt(i) == s.charAt(j)){
                    if(j-i <= K)return "Uncertain";
                }
        return "Certain";
    }
}
