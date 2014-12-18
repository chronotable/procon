import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int n = sc.nextInt();
            if(n == 0)break;
            int[] s = new int[n];
            for(int i = 0; i < n; i++)
                s[i] = sc.nextInt();
            int total = n * (n-1) / 2;
            int sum = 0;
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++)
                    if(gcd(s[i], s[j]) == 1)
                        sum++;
            }
            if(sum == 0){
                System.out.println("No estimate for this data set.");
            }else{
                double ans = sqrt(6.0 * total / sum);
                System.out.printf("%.6f\n", ans);
            }
        }
    }
    static int gcd(int a, int b){
        if(a < b) return gcd(b, a);
        if(a%b == 0)return b;
        return gcd(b, a%b);
    }
}
