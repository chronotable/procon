import java.util.*;
import static java.lang.Math.*;

public class StringFragmentation{
    boolean ok(String[] words, int w, int h, int f){
        int n = words.length;
        int y = 2*f;
        int x = 0;
        for(int i = 0; i < n; i++){
            int len = words[i].length();
            if(len * (f+2) > w)return false;
            if(x + len * (f+2) > w){
                x = 0;
                y += 2*f;
            }
            x += (len+1) * (f+2);
        }
        return y <= h;
    }
    public int largestFontSize(String text, int w, int h){
        String[] words = text.split(" ");
        int left = 8, right = 10000;
        while(left <= right){
            int m = (left + right) >> 1;
            if(ok(words, w, h, m))left = m+1;
            else right = m-1;
        }
        if(right < 8)return -1;
        return right;
    }
}
