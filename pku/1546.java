import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            String org = sc.next();
            int from = sc.nextInt();
            int to = sc.nextInt();
            String ans = convert(translate(org, from), to);
            System.out.printf("%7s\n",ans);
        }
    }
    int translate(String s, int base){
        int cur = 1;
        int ret = 0;
        for(int i = s.length()-1; i >= 0; i--){
            char c = s.charAt(i);
            int v = 0;
            if(Character.isDigit(c)) v = c - '0';
            else v = c - 'A' + 10;
            ret += cur * v;
            cur *= base;
        }
        return ret;
    }
    String convert(int v, int base){
        String ret = "";
        while(v > 0){
            int mod = v % base;
            if(mod < 10) ret = mod + ret;
            else ret = (char)(mod - 10 + 'A') + ret;
            v /= base;
        }
        if(ret.length() > 7) return "ERROR";
        return ret;
    }
}
