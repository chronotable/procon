import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int o = sc.nextInt();
        for(int c = 1; c<=o;c++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int ansl = 0, ansr = 0;
            while(l != 1 || r != 1){
                if(l < r){
                    int d = r / l;
                    if(r == l * d)d--;
                    r -= l * d;
                    ansr += d;
                }else{
                    int d = l / r;
                    if(l == r * d)d--;
                    l -= r * d;
                    ansl += d;
                }
            }
            System.out.printf("Scenario #%d:\n", c);
            System.out.printf("%d %d\n\n", ansl, ansr);
        }
    }
}
