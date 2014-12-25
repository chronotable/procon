import java.util.*;
import static java.lang.Math.*;

public class MagicalStringDiv1{
    public int getLongest(String S){
        char[] s = S.toCharArray();
        int n = s.length;
        for(int a = n; a > 0; a--){
            if(a % 2 == 1)continue;
            int k = a / 2;
            int cur = 0;
            int first = 0;
            while(first < k && cur < n){
                if(s[cur] == '>')first++;
                cur++;
            }
            int second = 0;
            while(second < k && cur < n){
                if(s[cur] == '<')second++;
                cur++;
            }
            if(first == k && second == k)return a;
        }
        return 0;
    }
}