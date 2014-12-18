import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for(int o = 0; o < n; o++){
            String f = sc.nextLine();
            int ci = 0;
            int lv = 0;
            int lx = 0;
            while(true){
                boolean plus = true;
                if(f.charAt(ci) == '='){
                    ci++;
                    break;
                }
                if(f.charAt(ci) == '-'){
                    ci++;
                    plus = false;
                }else if(f.charAt(ci) == '+'){
                    ci++;
                }
                int v = 0;
                for(;Character.isDigit(f.charAt(ci));ci++){
                    v = v * 10 + (f.charAt(ci) - '0');
                }
                if(f.charAt(ci) == 'x'){
                    ci++;
                    if(plus)lx += (v > 0) ? v : 1;
                    else lx -= (v > 0) ? v : 1;
                }else{
                    if(plus)lv += (v > 0) ? v : 1;
                    else lv -= (v > 0) ? v : 1;
                }
            }
            int rv = 0;
            int rx = 0;
            f = f + "=";
            while(true){
                boolean plus = true;
                if(f.charAt(ci) == '='){
                    ci++;
                    break;
                }
                if(f.charAt(ci) == '-'){
                    ci++;
                    plus = false;
                }else if(f.charAt(ci) == '+'){
                    ci++;
                }
                int v = 0;
                for(;Character.isDigit(f.charAt(ci));ci++){
                    v = v * 10 + (f.charAt(ci) - '0');
                }
                if(f.charAt(ci) == 'x'){
                    ci++;
                    if(plus)rx += (v > 0) ? v : 1;
                    else rx -= (v > 0) ? v : 1;
                }else{
                    if(plus)rv += (v > 0) ? v : 1;
                    else rv -= (v > 0) ? v : 1;
                }
            }
            if(lv == rv && lx == rx){
                System.out.println("IDENTITY");
            }else if(lx == rx){
                System.out.println("IMPOSSIBLE");
            }else{
                int ans = (int)floor(1.0 * (rv - lv) / (lx - rx));
                System.out.println(ans);
            }
        }
    }
}
