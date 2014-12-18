import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            if(a+b+c+d==0)break;
            int abmx = max(a,b);
            int abmn = min(a,b);
            int cdmx = max(c,d);
            int cdmn = min(c,d);
            double mxr = 1.0 * cdmx / abmx;
            double mnr = 1.0 * cdmn / abmn;
            int ans = (int)floor(min(mxr, mnr) * 100);
            if(ans > 100) ans = 100;
            System.out.println(ans + "%");
        }
    }
}
