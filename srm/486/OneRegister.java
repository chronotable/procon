import java.util.*;
import static java.lang.Math.*;

public class OneRegister{
    String which(String s, String t){
        if(s.length() < t.length())return s;
        else if(s.length() > t.length())return t;
        return s.compareTo(t) < 0 ? s : t;
    }
    String search(long s, long t){
        if(s > t)return null;
        if(s == t)return "";
        String mul = null, pls = null;
        if(s > 1){
            mul = search(s * s, t);
            if(mul != null)mul = "*" + mul;
        }
        pls = search(s + s, t);
        if(pls != null)pls = "+" + pls;
        if(mul != null && pls != null)return which(mul, pls);
        else if(mul != null)return mul;
        else if(pls != null)return pls;
        return null;
    }
    public String getProgram(int s, int t){
        String a = search(s, t);
        String b = search(1, t);
        if(b != null)b = "/" + b;
        if(a != null && b != null)return which(a, b);
        else if(a != null)return a;
        else if(b != null)return b;
        return ":-(";
    }
}
