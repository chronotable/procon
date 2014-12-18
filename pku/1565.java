import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(;;){
            String s = sc.next();
            if(s.equals("0"))break;
            int len = s.length();
            long ans = 0;
            for(int i = 0; i < len;i++){
                long bv = (long)pow(2, len-i) - 1;
                int sv = s.charAt(i) - '0';
                ans += 1l * sv * bv;
            }
            System.out.println(ans);
        }
    }
}
