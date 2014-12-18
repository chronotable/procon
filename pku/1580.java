import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(;;){
            String s = sc.next();
            if(s.equals("-1"))break;
            String t = sc.next();
            int mx = max(calc(s,t), calc(t,s));
            int bunshi = mx*2;
            int bunbo = s.length() + t.length();
            int g = gcd(bunshi, bunbo);
            bunshi /= g;
            bunbo /= g;
            System.out.printf("appx(%s,%s) = ", s, t);
            if(bunshi == 0)System.out.println(0);
            else if(bunshi==bunbo)System.out.println(1);
            else System.out.println(bunshi + "/" + bunbo);
        }
    }

    static int calc(String a, String b){
        int ret = 0;
        for(int i = 0; i < a.length(); i++){
            int sum = 0;
            for(int j = 0; j < b.length() && i+j < a.length();j++){
                if(a.charAt(j+i) == b.charAt(j))sum++;
            }
            ret = max(ret, sum);
        }
        return ret;
    }

    static int gcd(int a, int b){
        if(a>b)return gcd(b,a);
        if(a==0)return b;
        return gcd(b%a, a);
    }
}
