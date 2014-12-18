import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            int n = sc.nextInt();
            int s = (int)sqrt(2*(n));
            int t = s*(s+1)/2;
            if(t >= n){
                t = s*(s-1)/2;
            }else{
                s++;
            }
            int a = -1, b = -1;
            if(s % 2 == 1){
                a = s - (n - t - 1);
                b = 1 + (n - t - 1);
            }else{
                a = 1 + (n - t - 1);
                b = s - (n - t - 1);
            }
            System.out.printf("TERM %d IS %d/%d\n", n, a, b);
        }
    }
}
