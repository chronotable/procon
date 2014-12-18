import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            int b = sc.nextInt();
            int w = sc.nextInt();
            if(b + w == 0){
                System.out.println("Impossible");
                continue;
            }
            int ans = 1;
            for(;;ans++){
                int total = ans * ans;
                int p = total / 2;
                int q = total - p;
                if((p <= b && q <= w) ||
                   (p <= w && q <= b))continue;
                break;
            }
            System.out.println(ans-1);
        }
    }
}
