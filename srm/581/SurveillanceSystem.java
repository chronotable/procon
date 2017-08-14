import java.util.*;
import static java.lang.Math.*;

public class SurveillanceSystem{
    public String getContainerInfo(String containers, int[] reports, int L){
        char[] c = containers.toCharArray();
        final int n = c.length;
        int s = n - L + 1;
        int[] watch = new int[s];
        for(int i = 0; i < s; i++)for(int j = 0; j < L; j++)if(c[i+j] == 'X')watch[i]++;
        int[] freq = new int[n+1];
        for(int r : reports)freq[r]++;
        int[] state = new int[n];
        for(int r = 0; r <= n; r++)if(freq[r] > 0){
                int[] count = new int[n];
                int cand = 0;
                for(int i = 0; i < s; i++)if(watch[i] == r){cand++; for(int j = 0; j < L; j++)count[i+j]++;}
                for(int i = 0; i < n; i++){
                    if(count[i] > cand - freq[r])state[i] += 2;
                    else if(count[i] > 0 && state[i] == 0)state[i] = 1;
                }
            }
        String ret = "";
        for(int i = 0; i < n; i++)ret += (state[i] == 0 ? "-" : (state[i] == 1 ? "?" : "+"));
        return ret;
    }
}
