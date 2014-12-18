import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	E[] tbl = new E[n];
	int ds = 0;
	for(int i = 0; i < n; i++){
	    int t = sc.nextInt();
	    int d = sc.nextInt();
	    ds += d;
	    tbl[i] = new E(t, d);
	}
	Arrays.sort(tbl);
	double ans = 0;
	for(int i = 0; i < n; i++){
	    ds -= tbl[i].d;
	    ans += 2.0 * tbl[i].t * ds;
	}
	System.out.printf("%.0f\n", ans);
    }

    class E implements Comparable<E>{
	int t, d;
	double r;
	E(int a, int b){
	    t = a;
	    d = b;
	    r = 1.0 * d / t;
	}
	public int compareTo(E e){
	    //if(this.d != e.d)return e.d - this.d;
	    //return this.t - e.t;
	    if(abs(this.r - e.r) < 1e-9)return this.t - e.t;
	    return Double.compare(e.r, this.r);
	}
    }
}
