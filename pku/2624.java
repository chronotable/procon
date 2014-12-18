import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            double[] x = new double[4];
            double[] y = new double[4];
            for(int i = 0; i < 4; i++){
                x[i] = sc.nextDouble();
                y[i] = sc.nextDouble();
            }
            double t;
            if(x[0] == x[2] && y[0] == y[2]){
                swap(x, 0, 1);
                swap(y, 0, 1);
            }else if(x[0] == x[3] && y[0] == y[3]){
                swap(x, 0, 1); swap(y, 0, 1);
                swap(x, 2, 3); swap(y, 2, 3);
            }else if(x[1] == x[3] && y[1] == y[3]){
                swap(x, 2, 3); swap(y, 2, 3);
            }
            double ax = x[3] - (x[1] - x[0]);
            double ay = y[3] - (y[1] - y[0]);
            System.out.printf("%.3f %.3f\n", ax, ay);
        }
    }

    void swap(double[] a, int i, int j){
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
