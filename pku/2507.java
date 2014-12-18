import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            double c = sc.nextDouble();
            double z,v;
            double l = 0, r = min(x, y);
            for(int i = 0; i < 2000; i++){
                z = (l+r) / 2.0;
                v = sqrt(x*x-z*z) * sqrt(y*y-z*z) /
                    (sqrt(x*x-z*z) + sqrt(y*y-z*z));
                if(v > c)l = z;
                else r = z;
            }
            System.out.printf("%.3f\n", l);
        }
    }
}
