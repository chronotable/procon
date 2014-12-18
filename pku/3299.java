import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    double calcT(double d, double humi){
        double e = 6.11 * exp(5417.7530 * ((1.0/273.16) - (1/(d+273.16))));
        double h = 0.5555 * (e-10.0);
        return humi - h;
    }

    double calcD(double humi, double t){
        double e = (humi - t) / 0.5555 + 10.0;
        double p = 1.0/273.16 - log(e/6.11)/5417.753;
        return (1.0 - 273.16*p) / p;
    }

    double calcH(double d, double t){
        double e = 6.11 * exp(5417.7530 * ((1.0/273.16) - (1/(d+273.16))));
        double h = 0.5555 * (e - 10.0);
        return h + t;
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        final double INIT = 1000;
        for(;;){
            String s = sc.next();
            if(s.equals("E"))break;
            double t = INIT,d = INIT,h = INIT;
            if(s.equals("T"))t = sc.nextDouble();
            else if(s.equals("D"))d = sc.nextDouble();
            else if(s.equals("H"))h = sc.nextDouble();
            s = sc.next();
            if(s.equals("T"))t = sc.nextDouble();
            else if(s.equals("D"))d = sc.nextDouble();
            else if(s.equals("H"))h = sc.nextDouble();
            if(t == INIT){
                t = calcT(d, h);
            }else if(d == INIT){
                d = calcD(h, t);
            }else{
                h = calcH(d, t);
            }
            System.out.printf("T %.1f D %.1f H %.1f\n", t, d, h);
        }
    }

}
