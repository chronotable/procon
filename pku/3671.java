import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stat = new int[n];
        for(int i = 0; i < n;i++)stat[i] = sc.nextInt();
        int on = 0;
        int[] one = new int[n];
        for(int i = 0; i < n;i++){
            one[i] = on;
            if(stat[i] == 1)on++;
        }
        int tn = 0;
        int[] two = new int[n];
        for(int i = n-1; i >= 0;i--){
            two[i] = tn;
            if(stat[i] == 2)tn++;
        }
        int mn = 1000000;
        int ind = -1;
        for(int i = 0; i < n;i++){
            int d = n - (one[i] + two[i]);
            if(d < mn){
                mn = d;
                ind = i;
            }
        }
        int ans = 0;
        for(int i = 0; i < ind;i++)if(stat[i] == 2)ans++;
        for(int i = ind+1;i < n;i++)if(stat[i] == 1)ans++;
        System.out.println(ans);
    }
}