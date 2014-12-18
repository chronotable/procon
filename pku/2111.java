import java.util.*;

public class Main{

    static int[][] memo;
    static Info[][] next;
    static int[][] f;
    static int[] dx = {2,1,-1,-2,-2,-1,1,2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static int n;

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();
	memo = new int[n][n];
	next = new Info[n][n];
	f = new int[n][n];
	for(int i = 0; i < n;i++)
	    for(int j = 0; j < n;j++)
		f[i][j] = sc.nextInt();
	int mx = 0;
	int mxi = 0;
	int mxj = 0;
	for(int i = 0; i < n;i++){
	    for(int j = 0; j < n;j++){
		int v = tra(i,j);
		if(v>mx){
		    mx = v;
		    mxi = i;
		    mxj = j;
		}else if(v==mx && f[mxi][mxj]>f[i][j]){
		    mxi = i;
		    mxj = j;
		}
	    }
	}
	System.out.println(mx);
	for(Info t = new Info(mxi,mxj);;){
	    System.out.println(f[t.a][t.b]);
	    Info u = next[t.a][t.b];
	    if(t.a==u.a && t.b==u.b)break;
	    t = u;
	}
    }

    static int tra(int i, int j){
	if(memo[i][j]>0)return memo[i][j];
	int mx = 0;
	int mxi = i;
	int mxj = j;
	for(int m = 0;m < 8;m++){
	    int ni = i + dy[m];
	    int nj = j + dx[m];
	    if(ni < 0 || ni >= n || nj < 0 || nj >= n)continue;
	    if(f[i][j] < f[ni][nj]){
		int v = tra(ni,nj);
		if(v>mx){
		    mx = v;
		    mxi = ni;
		    mxj = nj;
		}else if(v==mx && f[mxi][mxj] > f[ni][nj]){
		    mxi = ni;
		    mxj = nj;
		}
	    }
	}
	memo[i][j] = mx+1;
	next[i][j] = new Info(mxi, mxj);
	return memo[i][j];
    }

    static class Info{
	int a,b;
	Info(int i, int j){a=i;b=j;}
    }
}