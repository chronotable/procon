import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] h = new int[n];
        for(int i = 0; i < n; i++)
            h[i] = sc.nextInt();
        int lim = 1 << n;
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < lim; i++){
            int sum = 0;
            for(int j = 0; j < n; j++)
                if(((i>>j) & 1) == 1)sum+=h[j];
            if(sum >= b)ans = min(ans, sum-b);
        }
        System.out.println(ans);
    }
}
