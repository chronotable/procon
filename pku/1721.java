import java.util.*;
import static java.lang.Math.*;

public class Main{

    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        //Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        int[][] tbl = new int[n][n];
        //String p = "";
        for(int i = 0; i < n; i++){
            tbl[0][i] = sc.nextInt() - 1;
            //p += to36(tbl[0][i]);
        }
        //ht.put(p, 0);
        for(int i = 1; i < n; i++){
            //p = "";
            for(int j = 0; j < n; j++){
                tbl[i][j] = tbl[i-1][tbl[i-1][j]];
                //p += to36(tbl[i][j]);
            }
            boolean f = true;
            for(int j = 0; j < n; j++){
                if(tbl[i][j] != tbl[0][j]){
                    f = false;
                    break;
                }
            }
            if(f){
                int dif = i;
                int g = i - (s % dif);
                for(int j = 0; j < n; j++)
                    System.out.println(tbl[g][j] + 1);
                return;
            }
        }
    }

}
