import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a+b==0)break;
            int mx = max(a,b);
            int mn = min(a,b);
            int[] aa = getCount(mn-1);
            int[] ba = getCount(mx);
            System.out.print(ba[0]-aa[0]);
            for(int i = 1; i < 10; i++)
                System.out.print(" " + (ba[i] - aa[i]));
            System.out.println();
        }
    }

    int[] getCount(int n){
        int[] ret = new int[10];
        if(n == 0)return ret;
        ret = getCount(n / 10);
        for(int i = 0; i < 10; i++)ret[i] *= 10;
        for(int i = 0; i < 10; i++){
            ret[i] += n / 10;
            if(i>0)ret[i]++;
        }
        int lim = n / 10 * 10 + 9;
        while(lim > n){
            int[] s = count(lim--);
            for(int i = 0; i < 10; i++)ret[i] -= s[i];
        }
        return ret;
    }

    int[] count(int v){
        int[] ret = new int[10];
        while(v > 0){
            ret[v%10]++;
            v /= 10;
        }
        return ret;
    }
}
