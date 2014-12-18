import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    final int[] dx = new int[]{1,0,-1,0};
    final int[] dy = new int[]{0,1,0,-1};

    int dfs(int[][] b, boolean[] u, int y, int x){
	int mx = 0;
	for(int i = 0; i < dx.length; i++){
	    int ny = y + dy[i];
	    int nx = x + dx[i];
	    if(ny < 0 || ny >= b.length || nx < 0 || nx >= b[0].length ||
	       u[b[ny][nx]])
		continue;
	    u[b[ny][nx]] = true;
	    mx = max(mx, dfs(b, u, ny, nx));
	    u[b[ny][nx]] = false;
	}
	return mx + 1;
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	int r = sc.nextInt();
	int c = sc.nextInt();
	int[][] b = new int[r][c];
	for(int i = 0; i < r; i++){
	    String s = sc.next();
	    for(int j = 0; j < s.length(); j++)
		b[i][j] = s.charAt(j) - 'A';
	}
	boolean[] u = new boolean[26];
	u[b[0][0]] = true;
	System.out.println(dfs(b, u, 0, 0));
    }
}