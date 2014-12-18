import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        for(;;){
            int n = Integer.parseInt(sc.nextLine());
            if(n == 0)break;
            boolean[][] con = new boolean[n][n];
            for(;;){
                String line = sc.nextLine();
                if(line.equals("0"))break;
                String[] elm = line.split(" ");
                int root = Integer.parseInt(elm[0]) - 1;
                for(int i = 1; i < elm.length; i++){
                    int leaf = Integer.parseInt(elm[i]) - 1;
                    con[root][leaf] = con[leaf][root] = true;
                }
            }
            int ans = 0;
            for(int i = 0; i < n; i++){
                boolean[] u = new boolean[n];
                u[i] = true;
                LinkedList<Integer> q = new LinkedList<Integer>();
                q.offer((i+1) % n);
                while(!q.isEmpty()){
                    int cur = q.poll();
                    if(u[cur])continue;
                    u[cur] = true;
                    for(int j = 0; j < n;j++){
                        if(con[cur][j] && !u[j])q.offer(j);
                    }
                }
                int k;
                for(k = 0; k < n; k++)if(!u[k])break;
                if(k != n)ans++;
            }
            System.out.println(ans);
        }
    }
}
