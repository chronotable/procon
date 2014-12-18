import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int o = 1; o <= t;o++){
            double r = sc.nextDouble();
            int n = sc.nextInt();
            System.out.printf("Scenario #%d:\n", o);
            System.out.printf("%.3f\n\n", r * sin(PI / n) / (1 + sin(PI / n)));
        }
    }
}