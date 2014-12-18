import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        String ans = "";
        for(long i = 1; n != 0; i *= -2){
            if(n % (i*-2) != 0){
                ans = "1" + ans;
                n -= i;
            }else{
                ans = "0" + ans;
            }
        }
        if(ans.length() == 0)ans = "0";
        System.out.println(ans);
    }
}
