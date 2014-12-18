import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    int n;
    boolean[][] con;
    int[] type;
    boolean ok;

    void tra(int p, int g){
        if(type[p] == g)return;
        else if(type[p] != 0 && type[p] != g){ok=false;return;}
        type[p] = g;
        for(int i = 1; i <= n;i++){
            if(con[p][i])tra(i,-g);
        }
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int o = 1; o <= t;o++){
            n = sc.nextInt();
            con = new boolean[n+1][n+1];
            type = new int[n+1];
            int e = sc.nextInt();
            for(int i = 0; i < e;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                con[a][b] = con[b][a] = true;
            }
            ok = true;
            for(int i = 1;ok && i <= n;i++){
                if(type[i] == 0)tra(i,1);
            }
            System.out.printf("Scenario #%d:\n", o);
            if(ok)System.out.println("No suspicious bugs found!");
            else System.out.println("Suspicious bugs found!");
            System.out.println();
        }
    }
}