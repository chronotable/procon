import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        int[] init = new int[9];
        int[][] move = new int[][]{
            {0,1,3,4,-1,-1},
            {0,1,2,-1,-1,-1},
            {1,2,4,5,-1,-1},
            {0,3,6,-1,-1,-1},
            {1,3,4,5,7,-1},
            {2,5,8,-1,-1,-1},
            {3,4,6,7,-1,-1},
            {6,7,8,-1,-1,-1},
            {4,5,7,8,-1,-1}
        };
        for(int i = 0; i < 9; i++)init[i] = sc.nextInt();
        int limit = 1 << 18;
        for(int m = 0; m < limit; m++){
            int[] state = new int[9];
            for(int i = 0; i < 9 ;i++)state[i] = init[i];
            int n = m;
            for(int i = 0; i < 9; i++){
                int v = n % 4;
                n = n >> 2;
                for(int k = 0; k < move[i].length; k++){
                    if(move[i][k] < 0)break;
                    state[move[i][k]] += v;
                    state[move[i][k]] %= 4;
                }
            }
            boolean f = true;
            for(int i = 0; i < 9; i++)
                if(state[i] != 0){
                    f = false;
                    break;
                }
            if(f){
                n = m;
                for(int i = 0; i < 9; i++){
                    int v = n % 4;
                    n = n >> 2;
                    for(int j = 0; j < v; j++)
                        System.out.print((i+1) + " ");
                }
                System.out.println();
                return;
            }
        }
    }
}
