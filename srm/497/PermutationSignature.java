import java.util.*;
import static java.lang.Math.*;

public class PermutationSignature{
    void reverse(int[] a, int start, int end){
        int n = end - start + 1;
        int[] b = new int[n];
        for(int i = 0; i < n; i++)b[i] = a[start + i];
        for(int i = start; i <= end; i++)a[i] = b[n + start - 1 - i];
    }
    public int[] reconstruct(String sig){
        final int n = sig.length() + 1;
        char[] s = sig.toCharArray();
        int[] ret = new int[n];
        for(int i = 0; i < n; i++)ret[i] = i+1;
        for(int i = n-2; i >= 0; i--)if(s[i] == 'D'){
                int end = i + 1;
                while(i >= 0 && s[i] == 'D')i--;
                i++;
                int start = i;
                reverse(ret, start, end);
            }
        return ret;
    }
}
