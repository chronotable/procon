import java.util.*;
import static java.lang.Math.*;

public class Main{

    private static final int[][] E = new int[][]{
        {1, 0},
        {0, 1}
    };
    private static final int MOD = 10000;

    void run(){
        Scanner sc = new Scanner(System.in);
        final int[][] F = new int[][]{
            {1, 1},
            {1, 0}
        };
        for(;;){
            int n = sc.nextInt();
            if(n < 0)break;
            int[][] ans = pow(F, n);
            System.out.println(ans[0][1]);
        }
    }

    int[][] mul(int[][] a, int[][] b){
        int len = a.length;
        int[][] m = new int[len][len];
        for(int i = 0; i < len;i++){
            for(int j = 0; j < len;j++){
                //m[i][j] = 0;
                for(int k = 0; k < len;k++){
                    m[i][j] += a[i][k] * b[k][j];
                }
                m[i][j] %= MOD;
            }
        }
        return m;
    }

    int[][] pow(int[][] a, int n){
        if(n==0)return E;
        if(n==1)return a;
        if(n % 2 == 1){
            return mul(pow(mul(a,a), n / 2), a);
        }else{
            return pow(mul(a, a), n / 2);
        }
    }

    public static void main(String[] args){
        new Main().run();
    }
}
