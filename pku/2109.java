import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            double n = sc.nextDouble();
            double p = sc.nextDouble();
            double l = 0, r = p, m, v;
            for(int i = 0; i < 1000; i++){
                m = (l+r)/2;
                v = log(p) / log(m);
                if(v > n)l = m;
                else r = m;
            }
            System.out.println((int)floor(l+0.5));
        }
    }
}
