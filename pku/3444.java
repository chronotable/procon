import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    int n = sc.nextInt();
	    if(n == 0)break;
	    int[] a = new int[n];
	    for(int i = 0; i < n; i++)
		a[i] = sc.nextInt();
	    int cur = 2;
	    int len = a.length;
	    while(cur <= len){
		int[] b = new int[len];
		for(int i = 0; i < cur; i++){
		    if(i % 2 == 0)
			b[i] = (a[i/2] + a[i/2 + cur/2]) / 2;
		    else
			b[i] = (a[i/2] - a[i/2 + cur/2]) / 2;
		}
		for(int i = cur; i < len; i++)
		    b[i] = a[i];
		a = b;
		cur *= 2;
	    }
	    for(int i = 0; i < len; i++){
		if(i > 0)System.out.print(" ");
		System.out.print(a[i]);
	    }
	    System.out.println();
	}
    }
}