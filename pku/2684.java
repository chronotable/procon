import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int n = sc.nextInt();
            if(n==0)break;
            PL[] tpl = new PL[2];
            int tm = sc.nextInt();
            int[] x = new int[tm];
            int[] y = new int[tm];
            int[] rx = new int[tm];
            int[] ry = new int[tm];
            for(int i = 0; i < tm; i++){
                x[i] = sc.nextInt(); y[i] = sc.nextInt();
                rx[tm-1-i] = x[i]; ry[tm-1-i] = y[i];
            }
            tpl[0] = new PL(x,y); tpl[1] = new PL(rx, ry);
            for(int o = 1; o <= n; o++){
                tm = sc.nextInt();
                x = new int[tm]; rx = new int[tm];
                y = new int[tm]; ry = new int[tm];
                for(int i = 0; i < tm; i++){
                    x[i] = sc.nextInt(); y[i] = sc.nextInt();
                    rx[tm-1-i] = x[i];
                    ry[tm-1-i] = y[i];
                }
                PL pl0 = new PL(x,y);
                PL pl1 = new PL(rx, ry);
                if(tpl[0].equals(pl0) || tpl[1].equals(pl0) ||
                   tpl[0].equals(pl1) || tpl[1].equals(pl1))
                    System.out.println(o);
            }
            System.out.println("+++++");
        }
    }

    class PL{
        int m;
        int[] len;
        //right = 1, left = -1
        int[] dir;
        PL(int[] x, int y[]){
            m = x.length - 1;
            len = new int[m];
            dir = new int[m];
            len[0] = abs(x[1] - x[0]) + abs(y[1] - y[0]);
            dir[0] = 0;
            for(int i = 2; i < x.length; i++){
                len[i-1] = max(abs(x[i] - x[i-1]), abs(y[i] - y[i-1]));
                if(x[i] == x[i-1]){
                    if(y[i] > y[i-1]){
                        if(x[i] > x[i-2])dir[i-1] = -1;
                        else dir[i-1] = 1;
                    }else{
                        if(x[i] > x[i-2])dir[i-1] = 1;
                        else dir[i-1] = -1;
                    }
                }else{
                    if(x[i] > x[i-1]){
                        if(y[i] > y[i-2])dir[i-1] = 1;
                        else dir[i-1] = -1;
                    }else{
                        if(y[i] > y[i-2])dir[i-1] = -1;
                        else dir[i-1] = 1;
                    }
                }
            }
        }

        public boolean equals(PL p){
            if(this.m != p.m)return false;
            for(int i = 0; i < m; i++){
                if(this.len[i] != p.len[i] ||
                   this.dir[i] != p.dir[i])return false;
            }
            return true;
        }

        public String toString(){
            String str = "";
            for(int i = 0; i < len.length;i++){
                str += String.format("%2d: %3d, %d\n", i, len[i], dir[i]);
            }
            return str;
        }
    }
}
