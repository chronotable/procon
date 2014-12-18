import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
    int ci;
    boolean unk = false;

    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            String atom = sc.next();
            if(atom.equals("END_OF_FIRST_PART"))break;
            int quantity = sc.nextInt();
            ht.put(atom, quantity);
        }
        for(;;){
            String formula = sc.next();
            if(formula.equals("0"))break;
            ci = 0;
            unk = false;
            int ans = tra(formula);
            if(unk)System.out.println("UNKNOWN");
            else System.out.println(ans);
        }
    }

    int tra(String f){
        int ret = 0;
        if(ci >= f.length()) return 0;
        char h = f.charAt(ci);
        if(h == '('){
            ci++;
            int v = tra(f);
            if(f.charAt(ci++) != ')');
                //System.out.println("()error");
            int multi = f.charAt(ci++) - '0';
            if(ci < f.length() && Character.isDigit(f.charAt(ci)))
                multi = multi * 10 + f.charAt(ci++) - '0';
            return v * multi + tra(f);
        }else if(h == ')'){
            return 0;
        }else{
            ci++;
            String atm = "" + h;
            if(ci < f.length()){
                char next = f.charAt(ci);
                if(next >= 'a' && next <= 'z'){
                    atm += next;
                    ci++;
                }
            }
            int multi = 1;
            if(ci < f.length()){
                char next = f.charAt(ci);
                if(Character.isDigit(next)){
                    ci++;
                    multi = next - '0';
                    if(ci < f.length()){
                        char nn = f.charAt(ci);
                        if(Character.isDigit(nn)){
                            ci++;
                            multi = multi * 10 + nn - '0';
                        }
                    }
                }
            }
            if(ht.containsKey(atm)){
                return multi * ht.get(atm) + tra(f);
            }else{
                unk = true;
                return 0;
            }
        }
    }
}
