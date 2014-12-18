import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    long p = sc.nextLong();
	    long q = sc.nextLong();
	    if(p + q == 0)break;
	    if(p == 0){
		System.out.println("0 2");
		continue;
	    }
	    long ansr = 100000, ansb=100000;
	    loop:
	    for(int i = 2; i <= 50000; i++){
		double db = calcBlack(p, q, i);
		double b = floor(db);
		if(1.0*i*(i-1)*q == 1.0*(i+b)*(i+b-1)*p && b < 50000.0){
		    long lb = (long)b;
		    if(i+lb <= 50000 && i+lb < ansr+ansb){
			ansr = 1l*i;
			ansb = lb;
			break loop;
		    }
		}
		b = b+1.0;
		if(1.0*i*(i-1)*q == 1.0*(i+b)*(i+b-1)*p && b < 50000.0){
		    long lb = (long)b;
		    if(i+lb <= 50000 && i+lb < ansr+ansb){
			ansr = 1l*i;
			ansb = lb;
			break loop;
		    }
		}
	    }
	    if(ansr > 50000)System.out.println("impossible");
	    else System.out.println(ansr + " " + ansb);
	}
    }

    double calcBlack(long p, long q, long r){
	return (-(2.0*r-1) +
		     sqrt(pow(2.0*r-1, 2.0) - 4.0*r*(r-1)*(1-1.0*q/p))) / 2.0;
    }
}