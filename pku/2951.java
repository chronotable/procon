import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    int[][][] dp = new int[21][21][21];
    static final int INF = Integer.MAX_VALUE;
    int tra(int a, int b, int d){
        if(dp[a][b][d]>0)return dp[a][b][d];
        if(d==1)return a*b;
        int res = INF;
        for(int i = 1; i < a;i++){
            int mn = min(i,a-i);
            int mx = max(i,a-i);
            for(int j = 1; j < d;j++){
                res = min(res,max(tra(max(mx,b), min(mx,b), j),
                                  tra(max(mn,b), min(mn,b),d-j)));
                res = min(res,max(tra(max(mn,b), min(mn,b), j),
                                  tra(max(mx,b), min(mx,b),d-j)));
            }
        }
        for(int i = 1; i < b;i++){
            int mn = min(i,b-i);
            int mx = max(i,b-i);
            for(int j = 1; j < d;j++){
                res = min(res,max(tra(max(mx,a), min(mx,a), j),
                                  tra(max(mn,a), min(mn,a),d-j)));
                res = min(res,max(tra(max(mn,a), min(mn,a), j),
                                  tra(max(mx,a), min(mx,a),d-j)));
            }
        }
        dp[a][b][d] = dp[b][a][d] = res;
        return res;
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int w = sc.nextInt();
            int h = sc.nextInt();
            int m = sc.nextInt();
            if(w+h+m==0)break;
            System.out.println(tra(max(w,h), min(w,h), m));
        }
    }
}