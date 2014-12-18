import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    static final int MAX = 32767;
    static final int SCALE = 15;
    static final int RM = BigDecimal.ROUND_HALF_UP;
    void run(){
        //System.out.println("gcd(16, 24 = )" + gcd(16,24));
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        BigDecimal obj = new BigDecimal(a).divide(new BigDecimal(b), SCALE, RM);
        int ansu = -1;
        int ansd = -1;
        BigDecimal mnd = new BigDecimal(1);
        for(int i = MAX; i > 0;i--){
            int d = (int)floor(1.0 * i * a / b + 0.5);
            for(int j = d; j <= d;j++){
                if(j < 1 || j * b == i * a)continue;
                BigDecimal bd = new BigDecimal(j).divide(new BigDecimal(i), SCALE, RM);
                BigDecimal dif = obj.subtract(bd).abs();
                if(dif.compareTo(mnd) < 0){
                    mnd = dif;
                    ansu = j;
                    ansd = i;
                }
            }
        }
        int g = gcd(ansu, ansd);
        ansu /= g;
        ansd /= g;
        System.out.println(ansu + " " + ansd);
    }

    int gcd(int a, int b){
        if(b>a)return gcd(b,a);
        if(b==0)return a;
        return gcd(b, a%b);
    }
}
