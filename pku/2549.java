import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int n = sc.nextInt();
            if(n == 0) break;
            int[] s = new int[n];
            for(int i = 0; i < n; i++){
                s[i] = sc.nextInt();
            }
            Arrays.sort(s);
            int[] sum = new int[n * n / 2 + 1];
            int sn = 0;
            for(int i = s.length-1; i >= 0; i--){
                for(int j = i - 1; j >= 0; j--){
                    sum[sn++] = s[i] + s[j];
                }
            }
            Arrays.sort(sum);
            int ans = Integer.MIN_VALUE;
            outer:
            for(int i = n - 1; i >= 0; i--){
                for(int j = i - 1; j >= 0; j--){
                    int v = s[i] - s[j];
                    if(Arrays.binarySearch(sum, v) >= 0 &&
                       Arrays.binarySearch(s, v - s[j]) < 0 &&
                       Arrays.binarySearch(s, -s[j]) < 0){
                        ans = s[i];
                        break outer;
                    }
                }
            }
            if(n < 4 || ans == Integer.MIN_VALUE){
                System.out.println("no solution");
            }else{
                System.out.println(ans);
            }
        }
    }
}
