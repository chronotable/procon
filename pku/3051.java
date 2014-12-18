
import java.util.*;

public class Main{

    private static boolean[][] pas;
    private static boolean[][] vis;

    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int w = sc.nextInt();
	int h = sc.nextInt();
	pas = new boolean[h+2][w+2];
	for(int i = 0; i < h;i++){
	    String pho = sc.next();
	    for(int j = 0; j < pho.length();j++){
		if(pho.charAt(j)=='*')pas[i+1][j+1] = true;
	    }
	}
	vis = new boolean[h+2][w+2];
	int ans = 0;
	for(int i = 1; i <= h;i++){
	    for(int j = 1;j <= w;j++){
		if(pas[i][j] && !vis[i][j]){
		    int v = tra(i,j);
		    if(v>ans)ans=v;
		}
	    }
	}
	System.out.println(ans);
    }

    private static int tra(int y, int x){
	vis[y][x] = true;
	int a=0,b=0,c=0,d=0;
	if(pas[y][x+1] && !vis[y][x+1])a = tra(y,x+1);
	if(pas[y+1][x] && !vis[y+1][x])b = tra(y+1,x);
	if(pas[y][x-1] && !vis[y][x-1])c = tra(y,x-1);
	if(pas[y-1][x] && !vis[y-1][x])d = tra(y-1,x);
	return 1 + a + b + c + d;
    }

}

