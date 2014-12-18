import java.util.*;
import java.math.*;

public class Main{

    static long[][] a;
    static int n;
    static int m;

    static long[][] find(long[][] x, int p){
	if(p==1)return x;
	if(p%2==1){
	    return mulmtrx(find(mulmtrx(x,x),p/2),x);
	}else{
	    return find(mulmtrx(x,x),p/2);
	}
    }

    static long[][] mulmtrx(long[][] g, long[][] h){
        long[][] ans = new long[4][4];
	for(int i = 0; i < 4;i++){
	    for(int j = 0; j < 4;j++){
		for(int k = 0; k < 4;k++){
		    long t = g[i][k] * h[k][j];
		    ans[i][j] += t;
		}
		ans[i][j] %= m;
	    }
	}
	return ans;
    }

    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	a = new long[4][4];
	a[0][0]=a[0][2]=a[1][0]=a[2][1]=a[3][2]=1;
	a[0][1]=5;
	a[0][3]=-1;
	long[] f = new long[4];
	f[0]=1;f[1]=5;f[2]=11;f[3]=36;
	for(;;){
	    n = sc.nextInt();
	    m = sc.nextInt();
	    if(n+m==0)break;
	    if(n <= 4){
		System.out.println(f[n-1]%m);
		continue;
	    }
	    long[][] d = new long[4][4];
	    for(int i = 0; i < 4;i++)
		for(int j = 0; j < 4;j++)
		    d[i][j]=a[i][j];
	    d = find(d,n-4);
	    long ans = 0;
	    for(int i = 0; i < 4;i++)ans += (d[0][i] * f[3-i]);
	    ans %= m;
	    if(ans < 0) ans += m;
	    System.out.println(ans);
	}
    }
}