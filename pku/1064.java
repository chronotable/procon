import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        //for(;sc.hasNext();){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] cable = new int[n];
            for(int i = 0; i < n; i++){
                double len = sc.nextDouble();
                cable[i] = (int)(len * 100);
            }
            int l = 1;
            int r = 20000000;
            int ans = 0;
            for(int o = 0; o < 100; o++){
                int m = (l+r)/2;
                int sum = 0;
                for(int i = 0; i < n; i++)
                    sum += cable[i] / m;
                if(sum >= k){
                    ans = max(ans, m);
                    l = m;
                }else{
                    r = m;
                }
            }
            System.out.printf("%.2f\n", ans/100.0);
            //}
    }
}
