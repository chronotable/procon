import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int o = 1; o<=t;o++){
            int n = sc.nextInt();
            int[] s = new int[n];
            for(int i = 0; i < n;i++)s[i] = sc.nextInt();
            int ans = 0;
            for(int i = n; i > 0;i--){
                for(int j = 0; j < i-1; j++){
                    if(s[j] > s[j+1]){
                        int h = s[j];
                        s[j] = s[j+1];
                        s[j+1] = h;
                        ans++;
                    }
                }
            }
            System.out.printf("Scenario #%d:\n", o);
            System.out.println(ans);
            if(o < t)System.out.println();
        }
    }
}
