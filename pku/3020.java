import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
        new Main().run();
    }

    int ast;
    boolean[][] con;
    int[] dest;
    boolean[] visit;

    void run(){
        Scanner sc = new Scanner(System.in);
        for(int o = sc.nextInt(); o > 0; o--){
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] f = new int[r][c];
            ast = 0;
            for(int i = 0; i < r; i++){
                String s = sc.next();
                for(int j = 0; j < c; j++){
                    if(s.charAt(j) == '*')
                        f[i][j] = ast++;
                    else
                        f[i][j] = -1;
                }
            }
            con = new boolean[ast][ast];
            int ans = 0;
            int[] dx = new int[]{1,0,-1,0};
            int[] dy = new int[]{0,1,0,-1};
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(f[i][j] >= 0){
                        for(int k = 0; k < dx.length; k++){
                            int ny = i + dy[k];
                            int nx = j + dx[k];
                            if(nx < 0 || nx >= c || ny < 0 || ny >= r ||
                               f[ny][nx] < 0)continue;
                            con[f[i][j]][f[ny][nx]] = true;
                        }
                    }
                }
            }
            dest = new int[ast];
            Arrays.fill(dest, -1);
            visit = new boolean[ast];
            System.out.println(ast - maxMatching() / 2);
        }
    }

    int maxMatching(){
        int ret = 0;
        for(int i = 0; i < ast; i++){
            visit = new boolean[ast];
            if(dfs(i))ret++;
        }
        return ret;
    }

    boolean dfs(int t){
        for(int i = 0; i < ast; i++){
            if(!visit[i] && con[t][i]){
                visit[i] = true;
                if(dest[i] < 0 || dfs(dest[i])){
                    dest[i] = t;
                    return true;
                }
            }
        }
        return false;
    }
}

