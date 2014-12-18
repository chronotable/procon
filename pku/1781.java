import java.util.*;
import static java.lang.Math.*;

public class Main{
    public static void main(String[] args){
	new Main().run();
    }

    void run(){
	Scanner sc = new Scanner(System.in);
	for(;;){
	    String s = sc.next();
	    int n = Integer.parseInt(s.substring(0,2));
	    int zn = Integer.parseInt(s.substring(3));
	    n = n * (int)pow(10, zn);
	    if(n == 0)break;
	    int pos = 1;
	    int bin = 1;
	    while(n > 1){
		bin *= 2;
		if(n % 2 == 1){
		    pos += bin;
		}
		n /= 2;
	    }
	    System.out.println(pos);
	}
    }
}