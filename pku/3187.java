import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    int n,s;
    int[][] comb;
    int[] ans;
    boolean f = false;

    void run(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        ans = new int[n];
        comb = new int[11][11];
        comb[0][0] = 1;
        for (int i = 1; i < 11; i++) {
            comb[i][0] = 1;
            for (int j = 1; j < 11; j++) {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }
        boolean[] u = new boolean[n+1];
        int[] a = new int[n];
        tra(0, a, u);
        for(int i = 0; i < n; i++){
            System.out.print(ans[i]);
            if(i < n-1)System.out.print(" ");
        }
    }

    void tra(int cur, int[] a, boolean[] u){
        if(cur == n){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += a[i] * comb[n-1][i];
            }
            if(sum == s){
                for(int i = 0; i < n;i++)ans[i] = a[i];
                f = true;
                return;
            }
        }
        if(f)return;
        for(int i = 1; i <= n; i++){
            if(!u[i]){
                u[i] = true;
                a[cur] = i;
                tra(cur+1, a, u);
                u[i] = false;
            }
        }
    }
}
