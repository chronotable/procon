import java.util.*;
import static java.lang.Math.*;

public class PalindromeGame{
    public int getMaximum(String[] front, int[] back){
        int n = front.length;
        C[] tbl = new C[n];
        for(int i = 0; i < n; i++)tbl[i] = new C(front[i], back[i]);
        Arrays.sort(tbl);
        int ans = 0;
        boolean[] u = new boolean[n];
        for(int i = 0; i < n; i++){
            if(u[i])continue;
            String rev = new StringBuilder(tbl[i].name).reverse().toString();
            for(int j = i+1; j < n; j++){
                if(!u[j] && rev.equals(tbl[j].name)){
                    u[i] = u[j] = true;
                    ans += tbl[i].score + tbl[j].score;
                    break;
                }
            }
        }
    
        int mx = 0;
        for(int i = 0; i < n; i++)if(!u[i] && tbl[i].isPalind())mx = max(mx, tbl[i].score);
    
        return ans + mx;
    }
}

class C implements Comparable<C>{
    String name;
    int score;
    C(String a, int b){
        name = a;
        score = b;
    }
    boolean isPalind(){
        int half = name.length() / 2;
        for(int i = 0; i < half; i++){
            if(name.charAt(i) != name.charAt(name.length() - i - 1)) return false;
        }
        return true;
    }
    public int compareTo(C c){
        return c.score - score;
    }
}
