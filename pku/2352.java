import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    int[] star = new int[32002];
    int[] lev = new int[15001];
    int lowbit(int n){
        return n & (-n);
    }
    int sum(int n){
        int res = 0;
        while(n!=0){
            res += star[n];
            n -= lowbit(n);
        }
        return res;
    }
    void update(int n){
        while(n < star.length){
            star[n]++;
            n += lowbit(n);
        }
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n;i++){
            int x = sc.nextInt();
            sc.nextInt();
            lev[sum(x+1)]++;
            update(x+1);
        }
        for(int i = 0; i < n;i++){
            System.out.println(lev[i]);
        }
    }

    /*
    //TLE
    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] dist = new int[n];
        int[] level = new int[n];
        int[] xd = new int[32010];
        for(int i = 0; i < n;i++){
            x[i] = sc.nextInt();
            sc.nextInt();
        }
        for(int i = 0; i < n;i++){
            boolean f = false;
            int j = i-1;
            for(; j >= 0;j--){
                if(x[j] <= x[i]){
                    f = true;
                    level[i] += level[j] + 1;
                    break;
                }
            }
            if(f){
                for(int k = x[j] + 1; k <= x[i]; k++)level[i] += xd[k];
            }
            dist[level[i]]++;
            xd[x[i]]++;
        }
        for(int i = 0; i < n;i++)System.out.println(dist[i]);
    }
    */
}