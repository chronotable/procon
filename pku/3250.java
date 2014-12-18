import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        int[] next = new int[n];
        for(int i = 0; i < n;i++)
            h[i] = sc.nextInt();
        long sum = 0;
        for(int i = n-1; i >= 0;i--){
            long t = 0;
            next[i] = i + 1;
            while(next[i] < n && h[i] > h[next[i]]){
                t += next[next[i]] - next[i];
                next[i] = next[next[i]];
            }
            sum += t;
        }
        System.out.println(sum);
    }
}
