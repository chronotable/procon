import java.util.*;
import static java.lang.Math.*;

public class Main{

    char[] s;
    int[][] tbl = new int[2001][2001];
    int[] cost = new int[300];

    public static void main(String[] args){
        new Main().run();
    }

    int solve(int l, int r){
        if(tbl[l][r] >= 0)return tbl[l][r];
        int ret = 0;
        if(r - l < 1){
            ret = 0;
        }else if(s[l] == s[r]){
            ret = solve(l+1,r-1);
        }else{
            ret = min(solve(l+1,r) + cost[s[l]],
                      solve(l,r-1) + cost[s[r]]);
        }
        return tbl[l][r] = ret;

    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        s = sc.next().toCharArray();
        for(int i = 0; i < n; i++){
            char c = sc.next().charAt(0);
            int a = sc.nextInt();
            int b = sc.nextInt();
            cost[c] = min(a,b);
        }
        for(int i = 0; i < tbl.length; i++)
            Arrays.fill(tbl[i], -1);
        System.out.println(solve(0,m-1));
    }

}
