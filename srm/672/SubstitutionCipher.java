import java.util.*;
import static java.lang.Math.*;

public class SubstitutionCipher{
    public String decode(String a, String b, String y){
        char[] dec = new char[26];
        boolean[] used = new boolean[26];
        int rest = 26;
        for(int i = 0; i < b.length(); i++){
            int j = b.charAt(i) - 'A';
            int k = a.charAt(i) - 'A';
            dec[j] = a.charAt(i);
            if(!used[k]){used[k] = true; rest--;}
        }
        if(rest == 1){
            for(int i = 0; i < used.length; i++)if(!used[i])for(int j = 0; j < dec.length; j++)if(dec[j] == 0)dec[j] = (char)('A' + i);
        }
        String ans = "";
        for(int i = 0; i < y.length(); i++){
            int j = y.charAt(i) - 'A';
            if(dec[j] == 0)return "";
            ans = ans + dec[j];
        }
        return ans;
    }
}
