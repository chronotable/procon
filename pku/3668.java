
import java.util.*;

public class Main{

    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[] x = new int[n];
	int[] y = new int[n];
	for(int i = 0; i < n;i++){
	    x[i] = sc.nextInt();
	    y[i] = sc.nextInt();
	}
	ArrayList<Frac> ar = new ArrayList<Frac>();
	int ans = 0;
	for(int i = 0; i < n - 1;i++){
	    for(int j = i+1; j < n;j++){
		Frac temp;
		if(x[i]!=x[j]){
		    int dx = x[i] - x[j];
		    int dy = y[i] - y[j];
		    if(dy == 0) dx = 1;
		    boolean f = false;
		    if((dx > 0 && dy < 0) || (dx < 0 && dy > 0))f = true;
		    dx = Math.abs(dx);
		    dy = Math.abs(dy);
		    int gv = gcd(dx,dy);
		    while(gv != 1){
			dx /= gv;
			dy /= gv;
			gv = gcd(dx,dy);
		    }
		    temp = new Frac(dx,dy,f);
		}else{
		    temp = new Frac(0,1,false);
		}
		ar.add(temp);
	    }
	}
	Collections.sort(ar);
	for(int i = 1; i < ar.size();i++)
	    if(!ar.get(i).equals(ar.get(i-1)))ans++;
	System.out.println(++ans);
    }

    private static int gcd(int a,int b){
	if(b==0)return a;
	if(a < b){
	    int temp = a;
	    a = b;
	    b = temp;
	}
	int m = a % b;
	return gcd(b,m);
    }

}

class Frac implements Comparable<Frac>{

    int a,b;
    boolean ism;

    Frac(int s, int t, boolean f){
	a = s;
	b = t;
	ism = f;
    }

    public int compareTo(Frac f){
	if(b==0)return 1;
	else if(f.b==0)return -1;
	double d = (double)a / b;
	if(ism)d = -d;
	double e = (double)f.a / f.b;
	if(f.ism) e = -e;
	if(d > e) return 1;
	else if(d < e) return -1;
	else return 0;
    }

    public String toString(){
	return "a=" + a + " b=" + b + " ism=" + ism;
    }

    public boolean equals(Frac f){
	return this.a == f.a && this.b == f.b && this.ism == f.ism;
    }

}
