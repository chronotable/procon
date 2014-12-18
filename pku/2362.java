import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    int n,len;
    int[] stc = new int[21];
    boolean[] u = new boolean[21];

    boolean dfs(int start, int no, int cur, int rest){
        int i,j;
        if(rest == 0){
            if(cur == len)return true;
            else return false;
        }
        if(cur == len){
            if(4 - no > rest)return false;
            for(i = 0; i < n;i++){
                if(!u[i])break;
            }
            u[i] = true;
            if(dfs(i+1, no+1,stc[i],rest-1))return true;
            u[i] = false;
            return false;
        }else{
            if(4 - no > rest - 1)return false;
            for(i = start; i < n;i++){
                if(!u[i] && cur + stc[i] <= len){
                    u[i] = true;
                    if(dfs(i+1, no, cur+stc[i], rest-1))return true;
                    u[i] = false;
                }
            }
            return false;
        }
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int o = sc.nextInt();
        for(;o>0;o--){
            n = sc.nextInt();
            int mx = 0, sum = 0;
            for(int i = 0; i < n;i++){
                stc[i] = sc.nextInt();
                sum += stc[i];
                mx = max(mx, stc[i]);
            }
            if(sum % 4 != 0 || mx > sum / 4){
                System.out.println("no");
                continue;
            }
            len = sum / 4;
            Arrays.fill(u,false);
            u[0] = true;
            if(dfs(1,1,stc[0],n-1))System.out.println("yes");
            else System.out.println("no");
        }
    }
}
