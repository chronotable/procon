import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            long n = sc.nextLong();
            int cur = 0;
            long sum = 0;
            int dig = 1;
            long lim = 10;
            int mx;
            for(mx = 1;;mx++){
                if(mx == lim){
                    lim *= 10l;
                    dig++;
                }
                cur += dig;
                sum += cur;
                if(sum >= n){
                    sum -= cur;
                    break;
                }
            }
            dig = 1;
            lim = 10;
            for(int j = 1; j <= mx; j++){
                if(j==lim){
                    lim *= 10l;
                    dig++;
                }
                if(sum + dig > n){
                    int dif = (int)(n - sum - 1);
                    String s = "" + j;
                    System.out.printf("%c\n", s.charAt(dif));
                    break;
                }else if(sum + dig == n){
                    System.out.println(j%10);
                    break;
                }
                sum += dig;
            }
        }
    }
}
