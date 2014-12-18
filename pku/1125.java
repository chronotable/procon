import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String args[]){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int n = sc.nextInt();
            if(n==0)break;
            int[][] sp = new int[n+1][n+1];
            for(int i = 1; i <= n; i++){
                int m = sc.nextInt();
                for(int j = 0; j < m;j++){
                    int counter = sc.nextInt();
                    int minute = sc.nextInt();
                    sp[i][counter] = minute;
                }
            }
            int ansi = -1;
            int ansm = 1000000;
            for(int i = 1; i <= n; i++){
                int rest = n;
                boolean[] u = new boolean[n+1];
                PriorityQueue<Integer> q = new PriorityQueue<Integer>();
                q.offer(i);
                while(!q.isEmpty()){
                    int v = q.poll();
                    int who = v % 1000;
                    int t = v / 1000;
                    if(u[who])continue;
                    u[who] = true;
                    rest--;
                    if(rest == 0){
                        if(ansm > t){
                            ansm = t;
                            ansi = i;
                        }
                        break;
                    }
                    for(int j = 1; j <= n;j++){
                        if(sp[who][j] > 0 && !u[j])
                            q.offer((t+sp[who][j]) * 1000 + j);
                    }
                }
            }
            if(ansi < 0)System.out.println("disjoint");
            else System.out.printf("%d %d\n", ansi, ansm);
        }
    }
}
