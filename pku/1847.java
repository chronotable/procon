import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt()-1;
        int b = sc.nextInt()-1;
        int[][] con = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(con[i],-1);
            int k = sc.nextInt();
            if(k == 0)continue;
            int p = sc.nextInt()-1;
            con[i][p] = 0;
            for(int j = 1; j < k; j++){
                p = sc.nextInt()-1;
                con[i][p] = 1;
            }
        }
        for(int k = 0; k < n; k++)
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    if(con[i][k] >= 0 && con[k][j] >= 0){
                        if(con[i][j] < 0)
                            con[i][j] = con[i][k] + con[k][j];
                        else
                            con[i][j] = min(con[i][j],
                                            con[i][k] + con[k][j]);
                    }
        System.out.println(con[a][b]);
    }
}
