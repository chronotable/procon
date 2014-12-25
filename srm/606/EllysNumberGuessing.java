import java.util.*;
import static java.lang.Math.*;

public class EllysNumberGuessing{
    public boolean in(int val){
        return 1 <= val && val <= 1000000000;
    }
    public int getNumber(int[] guesses, int[] answers){
        HashSet<Integer> cand = new HashSet<Integer>();
        int n = guesses.length;
        for(int i = 0; i < n; i++){
            HashSet<Integer> next = new HashSet<Integer>();
            int p = guesses[i] + answers[i];
            int s = guesses[i] - answers[i];
            if(cand.size() == 0){
                if(in(p))cand.add(p);
                if(in(s))cand.add(s);
                if(cand.size() == 0)return -2;
            }else{
                if(in(p) && cand.contains(p))next.add(p);
                if(in(s) && cand.contains(s))next.add(s);
                if(next.size() == 0)return -2;
                cand = next;
            }
        }
        if(cand.size() > 1)return -1;
        else {
            for(int v : cand)return v;
        }
        return -2;
    }
}