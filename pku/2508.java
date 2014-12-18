import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String args[]){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            double r = sc.nextDouble();
            double h = sc.nextDouble();
            double p = hypot(r, h);
            double arc = PI * 2 * r;
            double ang = arc / p;
            double d1 = sc.nextDouble();
            double a1 = sc.nextDouble() * 2 * PI / 360;
            double d2 = sc.nextDouble();
            double a2 = sc.nextDouble() * 2 * PI / 360;
            if(a1 >= a2 && abs(a1-a2) > abs(a2 - (a1-2*PI)))
                a1 -= 2*PI;
            if(a2 >= a1 && abs(a1-a2) > abs(a1 - (a2-2*PI)))
                a2 -= 2*PI;
            double x1 = d1 * cos(a1 / (2 * PI) * ang);
            double y1 = d1 * sin(a1 / (2 * PI) * ang);
            double x2 = d2 * cos(a2 / (2 * PI) * ang);
            double y2 = d2 * sin(a2 / (2 * PI) * ang);
            System.out.printf("%.2f\n", hypot(x1 - x2, y1 - y2));
        }
    }
}
