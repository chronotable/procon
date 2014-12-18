import java.util.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    boolean[][] g;
    int[] link;
    boolean[] s;
    int n,m;

    boolean find(int x){
        for(int i = 0; i < n; i++){
            if(!s[i] && g[x][i]){
                s[i] = true;
                if(link[i] < 0 || find(link[i])){
                    link[i] = x;
                    return true;
                }
            }
        }
        return false;
    }

    void run(){
        Scanner sc = new Scanner(System.in);
        for(;sc.hasNext();){
            n = sc.nextInt();
            m = sc.nextInt();
            if(n+m==0)break;
            g = new boolean[n][n];
            link = new int[n];
            Arrays.fill(link, -1);
            for(int i = 0; i < m; i++)
                g[sc.nextInt()-1][sc.nextInt()-1] = true;
            for(int k = 0; k < n; k++)
                for(int i = 0; i < n; i++)
                    for(int j = 0; j < n; j++)
                        g[i][j] |= (g[i][k] && g[k][j]);
            int ans = 0;
            for(int i = 0; i < n; i++){
                s = new boolean[n];
                if(find(i))ans++;
            }
            System.out.println(n-ans);
        }
    }
}
