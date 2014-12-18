import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int[] a = new int[100000];
	double x = 0.0;
	for(int i = 1; i < 100000;i++){
	    x += log10((double)i);
	    a[i] = (int)x + 1;
	}
	int t = sc.nextInt();
	for(;t>0;t--){
	    int n = sc.nextInt();
	    if(n < 100000){
		System.out.println(a[n]);
		continue;
	    }
	    double ans = n*log10((double)n) - n*log10(E) +
		log10(2*PI*n)/2.0 + 1;
	    ans = floor(ans+0.5);
	    System.out.println((int)ans);
	}
    }
}