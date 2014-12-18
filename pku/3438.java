import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int o = sc.nextInt(); o > 0; o--){
            String s = sc.next();
            String ans = "";
            char cur = s.charAt(0);
            int n = 1;
            for(int i = 1; i < s.length(); i++){
                if(cur != s.charAt(i)){
                    ans += "" + n + cur;
                    cur = s.charAt(i);
                    n = 1;
                }else{
                    n++;
                }
            }
            ans += "" + n + cur;
            System.out.println(ans);
        }
    }
}
