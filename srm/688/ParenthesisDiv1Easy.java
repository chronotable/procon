import java.util.*;
import static java.lang.Math.*;

public class ParenthesesDiv1Easy{
    public int[] correct(String S){
        char[] s = S.toCharArray();
        int n = s.length;
        if(n % 2 == 1)return new int[]{-1};
        ArrayList<Character> cs = new ArrayList<Character>();
        ArrayList<Integer> is = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(cs.size() > 0 && cs.get(cs.size() - 1) == '(' && s[i] == ')'){cs.remove(cs.size() - 1); is.remove(is.size() - 1);}
            else{cs.add(s[i]); is.add(i);}
        }
        if(cs.size() == 0)return new int[]{};
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i <= cs.size(); i++)if((i > 0 && i == cs.size()) || cs.get(i) == '('){
                if(i == 0)break;
                int a = is.get(0);
                int b = is.get(i-1);
                ans.add(a);
                ans.add(b);
                for(int j = 0; j < i; j++)is.set(j, b-is.get(j)+a);
                ArrayList<Integer> next = new ArrayList<Integer>();
                for(int j = i-1; j >= 0; j--)next.add(is.get(j));
                for(int j = i; j < is.size(); j++)next.add(is.get(j));
                is = next;
                break;
            }
        ans.add(is.get(is.size()/2));
        ans.add(is.get(is.size()-1));

        int[] ret = new int[ans.size()];
        for(int i = 0; i < ret.length; i++)ret[i] = ans.get(i);
        return ret;
    }
}
